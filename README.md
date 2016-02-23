# eej-spring-utilities
Spring dependent utilities

This package main goal is to handle via spring and reflection the necessary stuff to bind all pieces involved in this tasks.

The complete suite is built by using together eej-utilities, @eej-spring-utilities and @eej-database-utilities, but all this three are packaged separetely to make possible the reutilization of some of the components.

This eej-spring-utilities depends on Spring 3.1 or higher (currently using 4.1.1.Release), but will (or at least should) work with any version greater or equal than 3.15.

When all pieces set, generating a Data Tables server-side pagination directly from data objects such as pojos, with full operational dynamic filtering is trivial.

The configuration is quite complex (TODO: shorthand classes with default simple configuration), but once done, getting a view page for each entity is easy and quick
