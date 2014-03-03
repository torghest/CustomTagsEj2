/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tags;

import JDBC.AccesoJDBC;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class consultaTabla extends TagSupport {
    
    private AccesoJDBC jdbc;
    
    public int doStartTag() throws JspTagException
    {
        jdbc = new AccesoJDBC();
        return SKIP_BODY;
    }

    public int doEndTag() throws JspTagException
    {
        try {
            ResultSet rs = this.jdbc.getEmpleados();
            ResultSetMetaData rsmd = rs.getMetaData();
            JspWriter jw = pageContext.getOut();
            if (rs.next()){
                jw.write("<table border=\"2\" align=\"center\">");
                jw.write("<tr>");
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    jw.write("<td bgcolor=\"#333333\"><font color=\"#DDDDDD\">"+rsmd.getColumnName(i)+"</td>");
                }
                jw.write("</tr>");
                do{
                    jw.write("<tr>");
                    for (int i = 1; i <= rsmd.getColumnCount(); i++){
                        String d = rs.getString(i);
                        jw.write("<td>"+((d == null)?"0":d)+"</td>");
                    }
                    jw.write("</tr>");
                } while (rs.next());
                jw.write("</table>");
            }
        } catch (IOException ex){
            throw new JspTagException("Excepcion "+ex.toString());
        } catch (SQLException sqlE) {
            throw new JspTagException("Excepcion "+sqlE.toString());
        }
        return  EVAL_PAGE;
    }
    
}
