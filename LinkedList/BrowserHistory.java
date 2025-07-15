public class BrowserHistory {

    class Node {
        String url;
        Node next;
        Node prev;

        Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void visit(String url) {
        Node newNode = new Node(url);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (tail != null && tail.prev != null) {
            tail = tail.prev;
            System.out.println("Moved Back to: " + tail.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void forward() {
        if (tail != null && tail.next != null) {
            tail = tail.next;
            System.out.println("Moved Forward to: " + tail.url);
        } else {
            System.out.println("No forward page.");
        }
    }

    public void displayHistory() {
        Node temp = head;
        int i = 1;
        System.out.println("Browsing History:");
        while (temp != null) {
            String marker = (temp == tail) ? " <== current" : "";
            System.out.println(i + ". " + temp.url + marker);
            temp = temp.next;
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Browser History ===");
        BrowserHistory bh = new BrowserHistory();

        bh.visit("https://google.com");
        bh.visit("https://github.com");
        bh.visit("https://stackoverflow.com");

        bh.back();
        bh.back();
        bh.forward();

        bh.visit("https://oracle.com");

        bh.displayHistory();

        System.out.println("\n=== Music Player History ===");
        BrowserHistory musicHistory = new MusicPlayerHistory();
        musicHistory.visit("www.spotify.com/Falling");
        musicHistory.visit("www.spotfigy.com/AlanWalker/playlists");
        musicHistory.back();
        musicHistory.displayHistory();
    }
}

class MusicPlayerHistory extends BrowserHistory {
    @Override
    public void visit(String songName) {
        super.visit(songName);
        System.out.println("Now playing: " + songName);
    }
}
