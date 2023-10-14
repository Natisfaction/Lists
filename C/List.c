#include "List.h"

int initializeList(List* list){
    // Make ALL the structs' elements to NULL, and set the index to 0
    list->element = NULL;
    list->sublist = NULL;
    list->index = 0;

    return 0;
}

void setType(List* list, int type){
    // If the sublist doesn't exists, create it, and then put the element inside the parent's list
    if(list->sublist->sublist == NULL){
        list->type = type;
    } else {
        setType(list->sublist, type);
    }
}

void addInt(List* list, int* element){
    addElement(list, element);
    setType(list, INT_ELEMENT);
}

void addChar(List* list, char element){
    addElement(list, &element);
    setType(list, CHAR_ELEMENT);
}

void addFloat(List* list, float element){
    
}

void addDouble(List* list, double element){
    
}

void addString(List* list, char* element){
    
}

void addElement(List* list, void* element){
    // If the sublist doesn't exists, create it, and then put the element inside the parent's list
    if(list->sublist == NULL) {
        list->sublist = malloc(sizeof(List));
        list->sublist->sublist = NULL;
        list->element = element;

        list->sublist->index = list->index + 1;
        list->type = 9;
    } else {
        addElement(list->sublist, element);
    }
}

void printList(List* list){
    // Last position
    if(list == NULL || list->element == NULL){
        printf("}\n");
        return;
    }

    // First position
    if(list->index == 0){
        printf("{%d", *((int*)list->element));
        printList(list->sublist);
        return;
    }
    
    // Other positions
    printf(", %d", *((int*)list->element));
    printList(list->sublist);
}