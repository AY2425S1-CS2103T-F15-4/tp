---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# WedLinker User Guide

WedLinker is your **essential desktop app for managing wedding-related contacts**, designed specifically for professional wedding planners.
**With a powerful Command Line Interface (CLI)**, WedLinker streamlines contact management through quick, intuitive commands. This means you can accomplish your tasks faster than with traditional GUI apps, giving you more time to focus on what matters most—creating memorable experiences for your clients.

While WedLinker excels with its CLI for speed, it still offers the valuable visual elements of a Graphical User Interface (GUI). The GUI provides an organised and intuitive layout, making it easy to manage your contacts, weddings, and tasks at a glance.
This combination of efficiency and clarity ensures that you can manage your wedding planning responsibilities with ease and precision.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have `Java 17` or above installed on your computer by performing the following:
   1. Open your system terminal
      1. Windows: <br>
         1. Hold down Windows button and R (⊞ Win + R ) 
         2. Type `cmd` and press enter
         
      1. MacOS -- do one of the following: <br>
          - Click the Launchpad icon in the Dock, type `Terminal` in the search field, then click Terminal, OR
          - In the Finder, open the `/Applications/Utilities` folder, then double-click Terminal.
   1. Type `java -version` and press enter
   1. If you have `Java 17 installed, the terminal should look something like:
   ```
         C:\Users\UserName>java -version
         java version "17.0.12" 2024-07-16 LTS
         Java(TM) SE Runtime Environment (build 17.0.12+8-LTS-286)
         Java HotSpot(TM) 64-Bit Server VM (build 17.0.12+8-LTS-286, mixed mode, sharing)
    ```
2. If you do not have Java 17 installed, or you are unsure, refer to the guide below.
   1. Download `Java 17` from the official website: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
   2. Select the installation package based on your Operating System. For Apple users select macOS, for Windows users select Windows.
   3. Follow the instruction guide to install Java on your device. For more information use this guide: https://docs.oracle.com/en/java/javase/23/install/overview-jdk-installation.html

2. Download the latest version of WedLinker from [here](https://github.com/AY2425S1-CS2103T-F15-4/tp/releases/). Select `WedLinker.jar` to begin the download.
![release.png](images/release.png)

3. Copy the file to the folder you want to use as the _home folder_ for your WedLinker.

4. Open WedLinker by double clicking the program file, `WedLinker.jar`.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/ABC Photography Studio` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG_NAME]` can be used as `n/John Doe t/guest` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG_NAME]…​` can be used as ` ` (i.e. 0 times), `t/guest`, `t/guest t/photographer` etc.

* Commands in WedLinker uses prefixes to specify the parameters. The prefixes are stated as such:
  * n/ Name
  * a/ Address
  * p/ Phone Number
  * e/ Email
  * t/ Tag
  * w/ Wedding
  * tk/ Task
  * d/ Date

* Parameters can be in any order.<br>
  * e.g. if the command specifies `n/NAME p/PHONE`, `p/PHONE n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  * e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* Similarly, extraneous prefixes (e.g. n/ or tk/) for commands that do not take in those prefixes will be processed as part of other inputs.<br>
  * e.g. when [adding a person](#adding-a-person-add), you can specify the prefixes `n/`, `p/`, `e/`, `a/`, `t/`, and `w/`. If the command specifies
  `add n/Betsy Crowe d/2020-04-11 tk/Buy place settings`, it will be interpreted as adding a person with the name `Betsy Crowe d/2020-04-11 tk/Buy place settings`

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

* Some commands have shorter keywords that speed up entering commands - these keywords are specified in the format of each command.

* For example, instead of typing in `assign-vendor 1`, you can type in `asv 1`

## General Features

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Listing all Persons : `list`

Shows a list of all saved [Persons](#person-features) in the WedLinker.

Format: `list`

### Listing all Weddings : `list-weddings` or `lw`

Shows a list of all [Weddings](#wedding-features) in the WedLinker.

Format: `list-weddings` or `lw`

### Listing all Tasks : `list-tasks` or `ltasks`

Shows a list of all [Tasks](#task-features) in the WedLinker

Format: `list-tasks` or `ltasks`

### Listing all Tags : `list-tags` or `ltags`

Shows a list of all [Tags](#tag-features) in the WedLinker

Format: `list-tags` or `ltags`

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

<box type="warning" seamless>

**Caution:**
This action is irreversible and cannot be undone. Please ensure you have backed up any important information before proceeding.
</box>

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

WedLinker data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

WedLinker data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, WedLinker will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the WedLinker to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

## Person Features

### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG_NAME]…​ [w/WEDDING_NAME]…​`

* **People in Wedlinker cannot have the same names. `NAME` is case-insensitive.**
  * So, if `John Doe` is already in Wedlinker, adding another `john doe` with different details will not work
* A person's name must contain only alphanumeric characters, spaces, or the following characters: / . - '
* A person's phone number should be at least 3 digits long.
* If the tags or weddings specified in the add command do not exist yet, they will be created

 
Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/XYZ Floral Services`
* `add n/Betsy Crowe e/betsycrowe@example.com a/ABC Photo Studio p/1234567 t/Photographer`

<box type="tip" seamless>

**Tip:** 
* Adding a person with tags or weddings that do not exist in Wedlinker will create all the tags and weddings!
Created weddings will have the person automatically assigned to their guest lists.

* A person can have any number of tags or weddings (including 0)

* A person's name must contain only alphanumeric characters, spaces, or the following characters: / . - '

</box>

<box type="warning" seamless>

**Warning:** Extraneous prefixes in the add command will be processed as part of other inputs.<br>
* e.g. when adding a person, you can specify the prefixes `n/, p/, e/, a/, t/, and w/`. If the command specifies
`add n/Betsy Crowe d/2020-04-11 tk/Buy place settings`, it will be interpreted as adding a person with the name `Betsy Crowe d/2020-04-11 tk/Buy place settings`
</box>



### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit PERSON_NUMBER [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS]`

* Edits the person at the specified `PERSON_NUMBER`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower` Edits the name of the 2nd person to be `Betsy Crower`

### Deleting a person : `delete`

Deletes the specified person from WedLinker.

Format: `delete PERSON_NUMBER`

* Deletes the person at the specified `PERSON_NUMBER`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find n/Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Searching people by any field: `find`

Finds all persons based on the specified keywords after the prefix representing the field, and displays them as a list with index numbers.

Format: `find n/NAME...` or `find p/PHONE...` or `find e/EMAIL...` or `find a/ADDRESS...` or `find t/TAG_NAME...` or `find w/WEDDING_NAME...` or `find tk/TASK_NAME...`

* The search is case-insensitive. e.g `hans` will match `Hans`.
* The prefix that corresponds to the field you want to search should be specified. e.g. use `find n/Alex` to search by name, use `find e/alex@gmail.com` to search by email.
* The keyword after the prefix must be specified and cannot be empty. e.g. `find a/` is not allowed as the keyword to search should be specified.
* The search will return partial matches and full matches.
* Only one field can be searched at a time, but multiple keywords can be searched for the same field by placing each keyword after the appropriate prefix. e.g. to search for people whose phone number contains either 98 or 64, you can enter the command `find p/98 p/64`. 
This will return all contacts that have either 98 ot 64 in their phone number.
* You can only specify one prefix to search for at a time. For example, `find n/Alex a/` is not allowed as it searches for keywords in more than one field in the same command.
* The order of the keywords does not matter. e.g. `n/Hans n/Bo` will return the same contacts as `n/Bo n/Hans`.

* `find p/973` returns all Contacts whose phone number contains 973
* `find n/alex n/david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find n/alex n/david'](images/findCommandName.png)
* `find t/guest` returns all Contacts tagged with 'guest' <br>
  ![result for `find t/guest](images/findCommandTag.png)
* `find w/Casey's Wedding` returns all Contacts involved with Casey's Wedding <br>

## Tag Features

### Creating a tag : `create-tag` or `ctag`

Creates a `Tag` within WedLinker to be used on contacts.

Format: `create-tag t/TAG_NAME` or`ctag t/TAG_NAME`

* `TAG_NAME` is case-insensitive. It should be alphanumeric and can contain whitespaces.
* Tags are unique in WedLinker, there would not be any duplicated Tags.
* Contacts can share Tags.
* Tags are case-insensitive, so you cannot have both a 'hotel manager' and 'Hotel Manager' tag
* If you want to create a Tag with a long name, it might not be shown clearly in the list.</br>
We recommend keeping names of Tags to a maximum of 50 characters long.</br>
You can use [list-tags](#listing-all-tags--list-tags-or-ltags) instead for better visuals.

### Assigning tag to contact : `tag`

Assigns a `Tag` to the specified person in WedLinker

Format: `tag PERSON_NUMBER t/TAG_NAME... [f/]`

* Tag a specified contact based on the `PERSON_NUMBER` with a `Tag`.
* `TAG_NAME` is case-insensitive.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.
* The `Tag` must exists in WedLinker before it can be assigned.
* If the `Tag` does not exist, you can use `f/` to force the creation and assignment of the `Tag`. The `f/` tag should appear after all the tags specified by `t/TAGNAME` in the command.


### Unassigning tag from contacts : `untag`

<box type="tip" seamless>

**Tip:** To see all current tags, use the [list-tags](#listing-all-tags--list-tags-or-ltags) command
</box>

Untags a `Tag` from a specified person in WedLinker

Format: `untag PERSON_NUMBER t/TAG_NAME...`

* Untag a specified contact based on their `PERSON_NUMBER` with a `Tag`.
* `TAG_NAME` is case-insensitive.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.

### Deleting a tag : `delete-tag` or `dtag`

Deletes a `Tag` from WedLinker.

Format: `delete-tag t/TAG_NAME [f/]` or `dtag t/TAG_NAME [f/]`

* Deletes a `Tag` from WedLinker.
* `TAG_NAME` is case-insensitive.
* The `Tag` must exists in WedLinker.
* The `Tag` cannot be assigned to any contacts.
* If the `Tag` is in used, you can use `f/` to force the deletion of the `Tag` and unassign this tag from all contacts.

## Wedding Features

### Adding a Wedding : `create-wedding` or `cw`

Creates a `Wedding` within WedLinker to be with contacts.

Format: `create-wedding w/WEDDING_NAME` or `cw w/WEDDING_NAME`

* The `WEDDING_NAME` should only contain alphanumeric characters, spaces or the following characters: / . , ' & : ( )
* `WEDDING_NAME` is case-insensitive.
* Weddings are unique in WedLinker, there would not be any duplicated Weddings.
* Contacts can be assigned to the Wedding using the [assign-wedding](#assigning-contact-to-a-wedding--assign-wedding-or-asw) command.
* If you want to create a Wedding with a long name, it might not be shown clearly in the list.</br>
  We recommend keeping names of Weddings to a maximum of 50 characters long.</br>
  You can use [list-weddings](#listing-all-weddings--list-weddings-or-lw) instead for better visuals.

### Assigning contact to a Wedding : `assign-wedding` or `asw`

Assigns a contact to a `Wedding`.

Format: `assign-wedding PERSON_NUMBER w/WEDDING_NAME…​ [p1/] [p2/] [f/]` or `asw PERSON_NUMBER w/WEDDING_NAME…​ [p1/] [p2/] [f/]`

* Assigns a specified contact to the `Wedding` based on their `PERSON_NUMBER`.
* `WEDDING_NAME` is case-insensitive.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.
* The `Wedding` must exists in WedLinker before it can be assigned.
* If the `Wedding` does not exist, you can use `f/` to force the creation and assignment of the `Wedding`.

### Editing Wedding details : `edit-wedding` or `ew`

Edits the details of a `Wedding`.

Format: `edit-wedding WEDDING_NUMBER [a/ADDRESS] [d/DATE]` or `ew WEDDING_NUMBER [a/ADDRESS] [d/DATE]`

* Edits the specific `Wedding` at the `WEDDING_NUMBER` when in [list-weddings](#listing-all-weddings--list-weddings-or-lw) view.
* The index **must be a positive integer** 1, 2, 3, …​.
* Existing values in the specified fields will be overwritten with the specified values.

### Unassigning contacts from a Wedding : `unassign-wedding` or `uw`

Unassigns a contact from a `Wedding` in WedLinker.

Format: `unassign-wedding PERSON_NUMBER w/WEDDING_NAME...` or `uw PERSON_NUMBER w/WEDDING_NAME...`

* Unassigns a contact that is assigned to a `Wedding`.
* `WEDDING_NAME` is case-insensitive.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.

### Deleting a Wedding : `delete-wedding` or `dw`

Deletes a `Wedding` from WedLinker.

Format: `delete-wedding w/WEDDING_NAME [f/]` or `dw w/WEDDING_NAME [f/]`

* Deletes a `Wedding` from WedLinker.
* `WEDDING_NAME` is case-insensitive.
* No contacts should be assigned to the `Wedding` before it is deleted.
* If there are still contacts assigned, you can use `f/` to force the deletion of the `Wedding`. This will unassign all contacts from that `Wedding`.

## Task Features

### Creating a Task : `create-task` or `ctask`

Creates a `Task` in WedLinker

Format: `create-task tk/TASK_DESCRIPTION [d/DATE] [d/DATE]` or `ctask tk/TASK_DESCRIPTION [d/DATE] [d/DATE]`

* Tasks may have no dates, a single date indicating a deadline, or two dates to define a start and end period.
* The dates can be specified under `DATE` with the format `d/YYYY-MM-DD`
* Tasks are unique in WedLinker, there would not be any duplicated tasks.
* `TASK_NAME` is case-sensitive.
* Tasks can be assigned to a contact using the [assign-task](#assigning-a-task-to-a-contact--assign-task-or-atask) command.

### Deleting a Task : `delete-task` or `dtask`

Deletes a `Task` from WedLinker

Format: `delete-task TASK_NUMBER` or `dtask TASK_NUMBER`

* Deletes the specific `Task` at the `TASK_NUMBER` when in [list-tasks](#listing-all-tasks--list-tasks-or-ltasks) view.
* The index **must be a positive integer** 1, 2, 3, …​.

### Assigning a Task to a contact : `assign-task` or `atask`

Format: `assign-task PERSON_NUMBER TASK_NUMBER` or `atask PERSON_NUMBER TASK_NUMBER`

* Assigns a `Task` to a contact.
* The indexes correspond to the indexes when in the [list-tasks](#listing-all-tasks--list-tasks-or-ltasks) view.
* The `PERSON_NUMBER` refers to the index of the person shown under the **People** column.
* The `TASK_NUMBER` refers to the index of the task shown under the **Tasks** column
* The indexes **must be positive integers** 1, 2, 3, …​.

### Unassigning a Task from a contact : `unassign-task` or `unatask`

Format: `unassign-task PERSON_NUMBER PERSON_TASK_NUMBER` or `unatask PERSON_NUMBER PERSON_TASK_NUMBER`

* Un-assigns a `Task` from a contact.
* The `PERSON_NUMBER` is the index of the person shown in the displayed person list. 
* The `PERSON_TASK_NUMBER` is the index of the task in the person's task list. e.g. if the contact with `PERSON_NUMBER` 4 has 2 tasks assigned, you would use the following command to unassign the person's second task: `unassign-task 4 2`.
* The indexes **must be positive integers** 1, 2, 3, …​.

### Marking a task as completed : `mark-task` or `mtask`

Format: `mark-task TASK_NUMBER...` or `mtask TASK_NUMBER...`

* Marks a `Task` as completed.
* The `TASK_NUMBER` correspond to the index of the task when in the [list-tasks](#listing-all-tasks--list-tasks-or-ltasks) view.
* The index **must be a positive integers** 1, 2, 3, …​.

### Unmarking a task  : `unmark-task` or `untask`

Format: `unmark-task TASK_NUMBER...` or `untask TASK_NUMBER...`

* Marks a `Task` as not completed.
* The `TASK_NUMBER` correspond to the index of the task when in the [list-tasks](#listing-all-tasks--list-tasks-or-ltasks) view.
* The index **must be a positive integers** 1, 2, 3, …​.

## Vendor Features

### Assigning a Vendor : `assign-vendor` or `asv`

Format: `assign-vendor PERSON_NUMBER` or `asv PERSON_NUMBER`

* Assigns an existing `Person` at the specified `PERSON_NUMBER` to become a `Vendor`.
* The `Vendor` now can have `Tasks` assigned to it. The full list of `Task` commands can be found [here](#task-features) 
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.

### Unassigning a Vendor : `unassign-vendor` or `uv`

Format: `unassign-vendor PERSON_NUMBER [f/]` or `uv PERSON_NUMBER [f/]`

* Unassigns a `Vendor` at the specified `PERSON_NUMBER` such that the `Person` is no longer a `Vendor`. `Tasks` can no longer be assigned to this `Person`. 
* No tasks should be assigned to the `Vendor` before it is unassigned.
* If there are still tasks assigned, you can use `f/` to force the unassignment of the `Vendor`. This will unassign all tasks currently assigned to that `Vendor`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous WedLinker home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary
Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/florist`
**Assign Wedding**    | `assign-wedding PERSON_INDEX w/WEDDING…​` or `asw PERSON_INDEX w/WEDDING…​` <br> e.g., `asw 2 w/Casey's Wedding w/Wedding August 29th`
**Clear**  | `clear`
**Create Tag**  | `create-tag t/TAG` or `ctag t/TAG` <br> e.g., `create-tag t/photographer`
**Create Task**  | `create-task tk/TASK_DESCRIPTION [REMARKS]` or `ctask tk/TASK_DESCRIPTION [REMARKS]` <br> e.g., `create-task tk/Meet Caterer` <br> `ctask tk/Order Wedding Cake d/2025-02-01` <br> `ctask tk/Bridal Gown Fittings d/2025-03-15 d/2025-03-17`
**Create Wedding**  | `create-wedding w/WEDDING` or `cw w/WEDDING` <br> e.g., `cw w/JJ's Wedding`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Delete Tag** | `delete-tag t/TAG` or `dtag t/TAG` <br> e.g., `delete-tag t/photographer`
**Delete Task** | `delete-task INDEX` or `dtask INDEX` <br> e.g., `dtask 6`
**Delete Wedding** | `delete-wedding w/WEDDING` or `dw w/WEDDING` <br> e.g., `delete-wedding w/Lav's Wedding`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Edit Wedding**   | `edit-wedding WEDDING_INDEX [p1/PERSON_INDEX] [p2/PERSON_INDEX] [a/ADDRESS] [d/DATE]…​`<br> or <br> `ew WEDDING_INDEX [p1/PERSON_INDEX] [p2/PERSON_INDEX] [a/ADDRESS] [d/DATE]…​` <br> e.g.,`edit-wedding 2 p1/3 a/Jurong Christian Church`
**Exit**   | `exit`
**Find**   | `find [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG] [w/WEDDING]`<br> e.g., `find n/James Jake`
**Help**   | `help`
**List**   | `list`
**List Weddings**   | `list-weddings` or `lw`
**List Tasks**   | `list-tasks` or `lt`
**Tag**   | `tag INDEX [t/TAG]…​` <br> e.g., `tag 2 t/florist t/photographer`
**Unassign Wedding**    | `unassign-wedding PERSON_INDEX w/WEDDING…​` or `uw PERSON_INDEX w/WEDDING…​` <br> e.g., `uw 2 w/John's Wedding`
**Untag**   | `untag INDEX [t/TAG]…​` <br> e.g., `untag 4 t/available t/chef`
