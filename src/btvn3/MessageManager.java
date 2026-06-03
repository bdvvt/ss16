package btvn3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageManager {
    private List<Message> messages = new ArrayList<>();
    public void sendMessage(String sender,String content){
        messages.add(new Message(sender,content,java.time.LocalDateTime.now()));
      System.out.println("tin nhắn đã được gửi");
    }
    public void showMessages(){
        if (messages.isEmpty()){
            System.out.println("chưa có tin nhắn");
            return;
        }
        messages.forEach(System.out::println);
    }
    public void filterBySender(String sender){
        messages.stream()
                .filter(m -> m.getSender().equalsIgnoreCase(sender))
                .forEach(System.out::println);
    }
    public void filterByDate(LocalDate date){
        messages.stream()
                .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                .forEach(System.out::println);
    }
}
