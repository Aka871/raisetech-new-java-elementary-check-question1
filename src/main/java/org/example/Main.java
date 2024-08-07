package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double firstNumber = 0;
    double secondNumber = 0;
    char operator;

    System.out.print("1番目の数字を入力してください:");
    while (true) {
      try {
        firstNumber = scanner.nextDouble();
        break;
      } catch (InputMismatchException e) {
        System.out.println("エラー：数字を入力してください！");
        scanner.next();
      }
    }

    System.out.print("演算子を入力してください (+, -, *, /): ");

    //charAt(0) は文字列の最初の文字を取得するメソッド。scanner.next()が返した文字列の0番目の文字を取得。
    operator = scanner.next().charAt(0);

    System.out.print("2番目の数字を入力してください:");
    while (true) {
      try {
        secondNumber = scanner.nextDouble();
        break;
      } catch (InputMismatchException e) {
        System.out.println("エラー：数字を入力してください！");
        scanner.next();
      }
    }

    double result = 0;

    switch (operator) {
      case '+':
        result = firstNumber + secondNumber;
        break;
      case '-':
        result = firstNumber - secondNumber;
        break;
      case '*':
        result = firstNumber * secondNumber;
        break;
      case '/':
        if (secondNumber != 0) {
          result = firstNumber / secondNumber;
        } else {
          System.out.println("0で割ることはできません。");
          scanner.close();
          return;
        }
        break;
      default:
        System.out.println("無効な演算子です。");
        scanner.close();
        return;
    }

    System.out.println("計算結果: " + result);
    scanner.close();
  }
}
