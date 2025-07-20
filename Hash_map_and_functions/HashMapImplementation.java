package Hash_map_and_functions;

class HashMap<K, V> {
    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size = 10;
    private Node[] map;

    private int getMapIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(K key, V value) {
        int index = getMapIndex(key);
        Node head = map[index];

        Node tail = head;
        while (tail != null) {
            if (tail.key.equals(key)) {
                tail.value = value;
                return;
            }
            tail = tail.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        map[index] = newNode;
    }

    public V get(K key) {
        int index = getMapIndex(key);
        Node tail = map[index];

        while (tail != null) {
            if (tail.key.equals(key)) {
                return tail.value;
            }
            tail = tail.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = getMapIndex(key);
        Node tail = map[index];
        Node prev = null;

        while (tail != null) {
            if (tail.key.equals(key)) {
                if (prev == null) {
                    map[index] = tail.next;
                } else {
                    prev.next = tail.next;
                }
                return;
            }
            prev = tail;
            tail = tail.next;
        }
    }
}
