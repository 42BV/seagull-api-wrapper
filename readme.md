Seagull API wrapper
==============
Seagull API wrapper is a wrapper for the Insightly API, which allows the user to
perform CRUD methods on Insightly entities, such as contacts, or organisations.


Getting started
--------------

To use the API Wrapper, you will need an Insightly API key. Calls are made to: https://api.insight.ly/v2.1/ by default.
Use this API key when creating an Insightly object: 

```java
    Insightly insightly = new Insightly("yourAPIKey");
```

If the URL for the Insightly API is outdated, you can use this constructor to provide a URL:
```java
    Insightly insightly = new Insightly("yourAPIKey", "newerAPIUrl");
```

When an Insightly object is created, the user can start using the Seagull API Wrapper.
To retrieve a list of contacts from Insightly you need the following code:

```java
    List<Contact> contactList = insightly.getContacts();
```
To retrieve a list of organisations from Insightly you need the following code:

```java
    List<Organisation> organisationList = insightly.getOrganisations();
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
* Add opportunities.

