package org.vaadin.marcus.spring;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinService;

import javax.servlet.http.Cookie;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

@Route("/")
public class Todo extends VerticalLayout implements AfterNavigationObserver{
    TextField todoField = new TextField();

    public void onAdd(ClickEvent event){
        String todoFieldValue = todoField.getValue();
        Checkbox checkbox = new Checkbox(todoFieldValue);

        todoList.add(checkbox);

    }

    public String getUserName(){
        for(Cookie cookie :VaadinService.getCurrentRequest().getCookies()){
            if(cookie.getName().equals("username")){
                return cookie.getName();
            }
        }
        return  " ";
    }



    VerticalLayout todoList = new VerticalLayout();

    public Todo() {

        Button addButton =new Button("Add");
        addButton.addClickListener(this::onAdd);


        add(new H1("TODO"),new H4("Hello" + getUserName()),todoList,new HorizontalLayout(todoField,addButton));

    }

    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {

        for (Cookie cookie : VaadinService.getCurrentRequest().getCookies()) {
            if (cookie.getName().equals("username")){
                return;
            }
        }

        getUI().ifPresent(ui -> {
            ui.navigate("/login.html");
        });

    }
}
