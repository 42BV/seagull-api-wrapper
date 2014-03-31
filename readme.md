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

License
-------
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

To-do
---------------
* Add organisations and opportunities.

