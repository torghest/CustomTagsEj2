/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tags;

import java.io.IOException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alumno
 */
public class pruebaStatic extends TagSupport {
    private static int num = 0;
    
    /**
     *
     * @return
     * @throws JspTagException
     */
    @Override
    public int doStartTag() throws JspTagException{
        num++;
        return SKIP_BODY;
    }
    
    /**
     *
     * @return
     * @throws JspTagException
     */
    @Override
    public int doEndTag() throws JspTagException{
        try{
            pageContext.getOut().write("Veces ejecutado el Tag: "+num);
        } catch (IOException ioe){
            throw new JspTagException("Excepcion: "+ioe.toString());
        }
        return EVAL_PAGE;
    }
}
