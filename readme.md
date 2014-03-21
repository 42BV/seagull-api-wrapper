Seagull API wrapper
==============
Seagull API wrapper is a wrapper for the Insightly API, which allows the user to
perform CRUD methods on entities, such as contacts, or organisations.


Getting started
--------------

The first two things that needed are the user's Insightly API key and the Insightly API URL.
Once these are known, an Insightly object has to be created:

```java
    Insightly insightly = new Insightly("yourApiKey", "theApiUrl");
```

When an Insightly object is created, the user can start using the Seagull API Wrapper.
To retrieve a list of contacts from you need the following code:

```java
    List<Contact> contactList = insightly.getContacts();
```

To-do
---------------
* Add organisations and opportunities.

