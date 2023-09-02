package D20230901;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener implements jakarta.servlet.http.HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(event.getName()+"="+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(event.getName()+"="+event.getValue() +"remove");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(event.getName()+":"+event.getValue()+"被替换成了"+session.getAttribute(event.getName()));
    }
}
