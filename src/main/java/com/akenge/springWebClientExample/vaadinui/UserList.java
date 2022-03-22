package com.akenge.springWebClientExample.vaadinui;

import com.akenge.springWebClientExample.domain.User;
import com.akenge.springWebClientExample.service.UserService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class UserList extends VerticalLayout {

    public UserList(UserService userService) {

        var griUsers = new Grid<User>(User.class);
        griUsers.setItems(userService.getUsers());
        griUsers.setColumns("name", "phone", "address.street", "company.name");
        add(griUsers);
    }
}
