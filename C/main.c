#include <stdio.h>
#include "List.h"

int main(){
    List l1;
    
    initializeList(&l1);

    int x = 7;
    int c = 5;

    addInt(&l1, &x);
    addInt(&l1, &c);

    printList(&l1);

    return 0;
}