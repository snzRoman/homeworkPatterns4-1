package customerInteraction;

import java.util.Scanner;

// Принцип инверсии зависимостей (обращение не к конкретной реализации Listener'a, а к интерфейсу)
// Принцип замены Барбары Лисков
// Класс выполняет только функцию общения с пользователем
public class ConsoleListener implements Listener{

    private static ConsoleListener consoleListener = null;
    Scanner scanner = new Scanner(System.in);

    @Override
    public String listen() {
        return scanner.nextLine();
    }

    @Override
    public void answer(String message) {
        System.out.println(message);
    }

    private ConsoleListener(){}

    public static ConsoleListener getInstance(){
        if (consoleListener == null){
            return new ConsoleListener();
        }else{
            return consoleListener;
        }
    }
}
