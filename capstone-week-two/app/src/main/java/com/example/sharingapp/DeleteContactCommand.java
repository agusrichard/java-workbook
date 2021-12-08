package com.example.sharingapp;

import android.content.Context;

public class DeleteContactCommand extends Command {
    private ContactList contactList;
    private Contact item;
    private Context context;

    public DeleteContactCommand(ContactList contactList, Contact item, Context context) {
        this.contactList = contactList;
        this.item = item;
        this.context = context;
    }

    public void execute() {
        contactList.deleteContact(item);
        setIsExecuted(contactList.saveContacts(context));
    }
}
