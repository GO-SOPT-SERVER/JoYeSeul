package org.example.Generic;

import java.lang.reflect.Array;

/**
 * 제네릭: 특정 타입을 사용자의 필요에 의해 지정할 수 있도록 하는 Generic(일반적인) 타입
 * 제네릭 타입을 선언 할 때 <> 내부 안에는 어떤 단어가 들어가도 된다. 하지만 코드의 가독성과 협업을 위해 대부분 다음 규칙을 사용한다.
 * <T>: Type
 * <E>: Element
 * <K>: Key
 * <V>: Value
 * <N>: Number
 */
public class arrayGeneric<T> {
    T array[]; //사실 ArrayList를 안쓰고 순수 배열로 쓰면 문제점이 많기는 함. 배열 크기가 정해져있을 수 밖에 없기 때문. 여기서는 제네릭을 위한 예시로만 생각하자.
    //T array[] = new T[size]; 하면 오류 남. 왜냐면 array의 인스턴스 생성 시 컴포넌트의 종류를 미리 알고 있어야 하기 때문이다.
    //따라서 사용할 때 컴포넌트의 종류를 알 수 있는 제네릭은 불가능 하다 !
    int index;

    public arrayGeneric( Class<T> type, int size) {
        this.index = 0;
        array = (T[]) Array.newInstance ( type , size );

    }

    void add(T element) {
        if (index < array.length-1) {
            array[index] = element;
            this.index++;
        } else {
            System.out.println("배열이 꽉 차서 더 이상 넣을 수 없습니다.");
        }
    }

    T pop() {
        if (index >= 0) {
            index--;
            return array[index];
        } else {
            System.out.println("배열이 꽉 차서 더 이상 넣을 수 없습니다.");
            return null;
        }
    }
}
