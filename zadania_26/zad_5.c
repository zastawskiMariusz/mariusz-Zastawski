#include <stdio.h>

int main() {
    char znak;

    printf("Podaj znak: ");
    scanf("%c", &znak);

    if ((znak >= 'A' && znak <= 'Z') || (znak >= 'a' && znak <= 'z')) {
        printf("To litera alfabetu.\n");
    } else {
        printf("To NIE jest litera alfabetu.\n");
    }

    return 0;
}
