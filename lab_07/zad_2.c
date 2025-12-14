#include <stdio.h>

int nwd(int num1, int num2) {
    if (num1 == 0) {
        return num2; 
    } else {
        return nwd(num1, num2 % num2);
    }
}

int main() {
    int num1 = 20;
    int num2 = 10;
    printf("NWD(%d, %d) = %d\n", num1, num2, nwd(num1, num2)); 
    return 0;
}
