#include "List.h"

int initializeList(List* list){
    list->element = NULL;
    list->sublist = NULL;
    list->index = 0;

    return 0;
}

void addElement(List* list, void* element){
    if(list->sublist == NULL) {
        list->sublist = malloc(sizeof(List));
        list->sublist->sublist = NULL;
        list->element = element;
    } else {
        addElement(list->sublist, element);
    }
}

void printList(List* list){
    if(list == NULL || list->element == NULL)
        return;

    if(list->index == 0)
        "{";

    printf("%d", *((int*)list->element));
    printList(list->sublist);
}