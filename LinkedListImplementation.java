import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
    public class LinkedListImplementation {
        public static void main(String[] args) {
            LinkedList<String> ll = new LinkedList<>();
            ll.addFirst("a");
            ll.addFirst("b");
            ll.addFirst("c");
            ll.addFirst("d");
            ll.addFirst("e");

            System.out.println(ll.converttoString());
        }

        /**
         * A linked list is a sequence of nodes with efficient element insertion and removal. This class contains a subset of the methods of the standard java.util.LinkedList class.
         */
        public static class LinkedList<String> {

            /**
             * Constructs an empty linked list.
             */
            public LinkedList() {
                first = null;
            }


            /**
             *Converts the linked list to a string (tried to use toString but gave an error)
             *
             * @return the linked list as a string.
             */

            public String converttoString() {
                String result = first.data;
                Node curr = first;

                while (curr.next != null) {
                    curr = curr.next;
                    // casts result + curr.data to a String and puts in result.
                    result = (String) (result + (curr.data + ", "));
                }
                return result;
            }

            /**
             * Returns the first element in the linked list.
             *
             * @return the first element in the linked list
             */
            public String getFirst() {
                if (first == null)
                    throw new NoSuchElementException();
                return first.data;
            }

            /**
             * Removes the first element in the linked list.
             *
             * @return the removed element
             */
            public String removeFirst() {
                if (first == null)
                    throw new NoSuchElementException();
                String element = first.data;
                first = first.next;
                return element;
            }

            /**
             * Adds an element to the front of the linked list.
             *
             * @param element the element to add
             */
            public void addFirst(String element) {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = first;
                first = newNode;
            }

            /**
             * Returns an iterator for iterating through this list.
             *
             * @return an iterator for iterating through this list
             */
            public LinkedListIterator listIterator() {
                return new LinkedListIterator();
            }

            private Node first;

            private class Node {
                public String data;
                public Node next;

                public String getData() {
                    return data;
                }

                public Node getNext()
                {
                    return next;
                }
            }

            private class LinkedListIterator implements ListIterator<String> {
                /**
                 * Constructs an iterator that points to the front
                 * of the linked list.
                 */
                public LinkedListIterator() {
                    position = null;
                    previous = null;
                }

                /**
                 * Moves the iterator past the next element.
                 *
                 * @return the traversed element
                 */
                public String next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    previous = position; // Remember for remove
                    if (position == null)
                        position = first;
                    else
                        position = position.next;
                    return position.data;
                }

                @Override
                public boolean hasPrevious() {
                    return false;
                }

                @Override
                public String previous() {
                    return null;
                }

                @Override
                public int nextIndex() {
                    return 0;
                }

                @Override
                public int previousIndex() {
                    return 0;
                }


                /**
                 * Tests if there is an element after the iterator
                 * position.
                 *
                 * @return true if there is an element after the iterator
                 * position
                 */
                public boolean hasNext() {
                    if (position == null)
                        return first != null;
                    else
                        return position.next != null;
                }

                /**
                 * Adds an element before the iterator position
                 * and moves the iterator past the inserted element.
                 *
                 * @param element the element to add
                 */
                public void add(String element) {
                    if (position == null) {
                        addFirst(element);
                        position = first;
                    } else {
                        Node newNode = new Node();
                        newNode.data = element;
                        newNode.next = position.next;
                        position.next = newNode;
                        position = newNode;
                    }
                    previous = position;
                }

                /**
                 * Removes the last traversed element. This method may
                 * only be called after a call to the next() method.
                 */
                public void remove() {
                    if (previous == position)
                        throw new IllegalStateException();
                    if (position == first) {
                        removeFirst();
                    } else {
                        previous.next = position.next;
                    }
                    position = previous;
                }

                @Override
                public void forEachRemaining(Consumer<? super String> action) {
                    ListIterator.super.forEachRemaining(action);
                }

                /**
                 * Sets the last traversed element to a different
                 * value.
                 *
                 * @param element the element to set
                 */
                public void set(String element) {
                    if (position == null)
                        throw new NoSuchElementException();
                    position.data = element;
                }

                private Node position;
                private Node previous;
            }
        }
    }
