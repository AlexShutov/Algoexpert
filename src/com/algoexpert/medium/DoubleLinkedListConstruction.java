package com.algoexpert.medium;

public class DoubleLinkedListConstruction {
    public static void main(String[] args) {
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        // O(1) time, O(1) space
        public void setHead(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                insertBefore(head, node);
            }
        }

        public void setTail(Node node) {
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                insertAfter(tail, node);
            }
        }

        // O(1) time, O(1) space
        public void insertBefore(Node node, Node nodeToInsert) {
            // Случай, когда мы вставляем в список, сосотоящий из одного узла, узел,
            // который итак на ходится в списке
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        // O(1) time, O(1) space
        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            if (node.next == null) {
                // вставляем в хвост списка
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        // O(p) time, O(1) space
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                // вставляем в корень
                setHead(nodeToInsert);
                return;
            }
            Node curr = head;
            int currPosition = 1;
            while (curr != null && currPosition != position) {
                curr = curr.next;
                currPosition++;
            }
            if (curr != null) {
                insertBefore(curr, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }
        }

        // O(n) time, O(1) space
        public void removeNodesWithValue(int value) {
            // проходим по всему списку в поисках нужного значнеия. Если найдем его -
            // удаляем
            Node curr = head;
            while (curr != null) {
                // важно - сохраним ссылку на текущий узели
                Node tmp = curr;
                // и сначала перейдем вперед до удаления.
                curr = curr.next;
                // Если же этого не сделать, то при удалении затрется ссылка на следующий
                // узел и не сможем перейти, будет NullPointerException
                if (tmp.value == value) {
                    remove(tmp);
                    // мы должны удалить все узлы с таким значением, если же нужно только первое -
                    //, тогда нужно раскомментировать return
//                    return;
                }
            }
        }

        // O(1) time, O(1) space
        public void remove(Node node) {
            if (node == tail) tail = tail.prev;
            if (node == head) head = head.next;
            removeNodeBindings(node);
        }

        public boolean containsNodeWithValue(int value) {
            // Обойдем весь список, пока не найдем нужное значение или же не обойдем весь список
            Node curr = head;
            while (curr != null || curr.value != value) {
                curr = curr.next;
            }
            // значение в curr будет нулл, если мы прошли весь список и ничего не нашли, иначе -
            // найденное значение
            return curr != null;
        }

        private void removeNodeBindings(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
