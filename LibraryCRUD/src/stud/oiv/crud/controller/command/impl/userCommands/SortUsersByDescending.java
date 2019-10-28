package stud.oiv.crud.controller.command.impl.userCommands;

import stud.oiv.crud.beans.User;
import stud.oiv.crud.controller.command.Command;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.ArrayList;
import java.util.Collections;

public class SortUsersByDescending implements Command {

    /**
     * <p>Выполняет сортировку пользователей по убыванию фамилии</p>
     * @param request не используется
     */
    @Override
    public String execute(String request) {
        ArrayList<User> allUsers = ServiceFactory.getInstance().getUserService().getAllUsers();
        Collections.sort(allUsers);
        Collections.reverse(allUsers);
        String result = "";
        for(User user: allUsers)
        {
            result += user.toString() + '\n';
        }
        return result;
    }
}