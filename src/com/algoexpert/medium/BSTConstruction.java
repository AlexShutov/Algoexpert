package com.algoexpert.medium;

import java.util.Set;
import java.util.TreeSet;

public class BSTConstruction {

    /**
     * {"arrayOne": [-1, 5, 10, 20, 3], "arrayTwo": [26, 134, 135, 15, 17]}
     * @param args
     */
    public static void main(String[] args) {

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;


        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                // Вставляем в левое дерево
                if (left == null) {
                    // новый узел
                    left = new BST(value);
                } else {
                    // идем влево по дереву

                    left.insert(value);
                }
            } else {
                // вставляем в правое поддерево
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                return true;
            }
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parent) {
            //  значение находится в левом поддереве
            if (value < this.value) {
                if (left != null) {
                    // текущий элемент будет родителем для следующей итеарции, ищем рекурсивно
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                // нужный элемент находится в правом поддереве
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                // нашли нужный элемент
                if (left != null && right != null) {
                    // и у него есть оба потомка, чтобы удалить его, ставим на место наименьший элемент из
                    // правого поддерева и затем удаляем его оттуда
                    this.value = getMinValue(right);
                    right.remove(this.value, this);
                } else if (parent == null) {
                    // случай, когда находимся в вершине дерева, у которого есть только одна дочерняя ветвь
                    if (left != null) {
                        this.value = left.value;
                        left = left.left;
                    } else if (right != null) {
                        // у дерева есть только правое поддерево
                        this.value = right.value;
                        right = right.right;
                    } else {
                        // случай, когда есть только одна вершина, которую нужно удалить, ничего не делаем
                    }
                } else if (this == parent.left) {
                    // случай, когда нужный узел является левым поддервом родителя и у нашего узла только одно
                    // поддерево:
                    //      P
                    //     /  \
                    //    N
                    //  /  \
                    // O
                    BST child = left != null ? left : right;
                    parent.left = child;
                } else if (this == parent.right) {
                    //      P
                    //     /  \
                    //          N
                    //         /  \
                    //             O
                    BST child = left != null ?  left : right;
                    parent.right = child;
                }
            }
        }

        private int getMinValue(BST tree) {
            // если в левом поддереве больше нет элементов, значит, мы находимся в листе с наименьшим значением
            if (tree.left == null) {
                return tree.value;
            } else {
                // иначе идем по левому поддереву в поисках наименьшего значения
                return left.getMinValue(tree.left);
            }
        }
    }
}
