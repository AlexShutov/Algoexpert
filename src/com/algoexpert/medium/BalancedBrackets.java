package com.algoexpert.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Stream;

public class BalancedBrackets {

    public static void main(String[] args) {

    }

    public static boolean balancedBrackets(String str) {
        Deque<Bracket> bracketStack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            // опеределяем скобку в текщей позиции
            Bracket currBracket = Bracket.parseBracket(str.charAt(i));
            // Помимо скобок могут быть и символы, пропустим неизвестный символ
            if (currBracket.mBracketType == BracketType.UNKNOWN) continue;
            // Если скобка открывающаяся - добавляем ее в стек
            if (currBracket.mIsOpening) {
                bracketStack.addLast(currBracket);
            } else {
                // Для закрывающейся скобки смотрим, чтобы ее тип совпадал с типом последней предыдущей
                // скобки в стеке
                if (bracketStack.isEmpty()) {
                    // у нас есть закрывающаяся скобка, хотя до нее не было открывающихся
                    return false;
                }
                Bracket lastBracket = bracketStack.peekLast();
                if (currBracket.mBracketType != lastBracket.mBracketType) {
                    // у нас получились пересекающиеся скобки, например,  ([)]
                    return false;
                } else {
                    // типы скобок совпадают, удаляем последнюю скобку из стека
                    bracketStack.removeLast();
                }
            }
        }
        // Нужно проверить, что в стеке не осталось скобок. Если же стек не пуст,
        // то это будет свидетельствовать о том, были отерывающиеся скобки без парной закрывающейся
        return bracketStack.isEmpty();
    }

    /**
     * Тип скобок
     */
    private enum BracketType {
        // ()
        ROUND,
        // []
        SQUARE,
        // {}
        CURLY,
        // ошибка
        UNKNOWN
    }

    /**
     * модель скобки
     */
    private static class Bracket {

        /**
         * Создаем скобки только при помощи вспомогательного метода
         *
         * @param type      тип скобки
         * @param isOpening открывающаяся ли скобка
         */
        private Bracket(BracketType type, boolean isOpening) {
            mBracketType = type;
            mIsOpening = isOpening;
        }

        // Тип скобки
        BracketType mBracketType;
        // Открывающаяся ли скобка
        boolean mIsOpening;

        /**
         * Опеределяет тип скобки по ее символу
         *
         * @param symbol символ
         * @return тип скобки
         */
        public static Bracket parseBracket(char symbol) {
            switch (symbol) {
                case '(':
                    return new Bracket(BracketType.ROUND, true);
                case ')':
                    return new Bracket(BracketType.ROUND, false);
                case '[':
                    return new Bracket(BracketType.SQUARE, true);
                case ']':
                    return new Bracket(BracketType.SQUARE, false);
                case '{':
                    return new Bracket(BracketType.CURLY, true);
                case '}':
                    return new Bracket(BracketType.CURLY, false);
                default:
                    return new Bracket(BracketType.UNKNOWN, true);
            }
        }
    }
}
