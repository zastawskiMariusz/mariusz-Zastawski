#include <stdio.h>

int main() {
    int a;

    printf("Podaj liczbę a: ");
    scanf("%d", &a);

    int c = a % 1;
    int d = a % a;
    if(a > 1 && d == 0 && a/4 != 1 ){
        printf("liczba c= %d jest liczbą pierwszą \n", a);
    }else
    printf("liczba c= %d nie jest liczbą pierwszą \n", a);
    


    return 0;
}
