import java.util.*;

class Solution {
    class Book {
        int start;
        int end;
        
        Book(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[][] book_time) {
        List<Book> bookList = new ArrayList<Book>();
        
        for(int i = 0, endi = book_time.length; i < endi; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            bookList.add(new Book( Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]), Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])));
        }
        
        Collections.sort(bookList, (o1, o2) -> {
            if(o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        });
        
        
        List<Integer> answerList = new ArrayList<>();
        
        for(Book book : bookList) {
            boolean check = true;
            Collections.sort(answerList);
            for(int i = 0 ;i < answerList.size(); i++){
                int endTime = answerList.get(i) + 10;
                if(book.start >= endTime) {
                    answerList.set(i, book.end);
                    check = false;
                    break;
                }
            }
            if(check) answerList.add(book.end);
        }
        
        return answerList.size();
    }
}