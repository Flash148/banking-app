# Project 1 Plan: Console Banking App

## The big picture

We're using two databases:

- **PostgreSQL** is basically the bank's official record. Customers, employees, accounts, balances, and every transaction go here.
- **MongoDB** is more like the employees' notebook. It holds the notes they write about accounts and a log of what each employee did.

One rule to keep in mind the whole time: **the money always comes first.** If a transfer goes through but the note about it fails to save, we don't undo the transfer. We just let the employee know the note didn't save so they can try again.

## Potential Split

I'd like each of us to own one "side" of the bank and build it all the way through, from the menus down to the database code and tests. That way we both get experience with every part of the project, and we're not stuck waiting on each other.

**Side A: the customer side.** This is everything a customer does: signing up, logging in, opening and closing accounts, deposits, withdrawals, transfers, and viewing their transaction history. It's all PostgreSQL. It also includes the main menu and the Postgres connection setup. Transfers are probably the trickiest part of the whole project, since a transfer has to fully go through or not happen at all.
*(User stories US-01 through US-18, plus US-21, US-26, and US-38)*

**Side B: the employee side.** This is everything bank staff do: employee login, looking up customers, wire transfers, freezing and unfreezing accounts, writing and filtering notes, flagging suspicious activity, and the activity logs. All of the MongoDB work lives here, along with the Mongo connection setup and creating the starting employee accounts. There are more features on this side, but a lot of them are similar to each other.
*(User stories US-19, US-20, US-22 through US-25, US-27 through US-37, and US-39)*

## Build First?

- The Java classes for our data (customers, accounts, transactions, notes, and so on)
- The database tables
- The interfaces that list which database methods we'll need

Once those exist, we can each work on our own side without blocking each other. We should also make sure Docker runs on both of our machines so we're testing against the same setup.

## Overlaps:

- **Wire transfers:** the employee side starts the wire, but it uses the customer side's transfer code to actually move the money, then saves a note about it. I think we should just pair program this one.
- **Frozen accounts:** when an employee freezes an account, the customer side needs to block withdrawals and transfers from it.
- **Login:** I'm thinking one main menu where you pick whether you're a customer or an employee, and each of us builds the screens that come after that.

