
    create table task_Attachment (
        id number(19,0) not null,
        accessType number(10,0),
        attachedAt date,
        attachmentContentId number(19,0) not null,
        contentType varchar2(255),
        name varchar2(255),
        size number(10,0) not null,
        attachedBy varchar2(255),
        TaskData_Attachments_Id number(19,0),
        primary key (id)
    );

    create table task_BooleanExpression (
        id number(19,0) not null,
        expression clob,
        type varchar2(255),
        Escalation_Constraints_Id number(19,0),
        primary key (id)
    );

    create table task_Comment (
        id number(19,0) not null,
        addedAt date,
        text clob,
        addedBy varchar2(255),
        TaskData_Comments_Id number(19,0),
        primary key (id)
    );

    create table task_Content (
        id number(19,0) not null,
        content blob,
        primary key (id)
    );

    create table task_Deadline (
        id number(19,0) not null,
        date date,
        escalated number(1,0) not null,
        Deadlines_StartDeadLine_Id number(19,0),
        Deadlines_EndDeadLine_Id number(19,0),
        primary key (id)
    );

    create table task_Delegation_delegates (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_EmailNotificationHeader (
        id number(19,0) not null,
        body clob,
        fromAddress varchar2(255),
        language varchar2(255),
        replyToAddress varchar2(255),
        subject varchar2(255),
        primary key (id)
    );

    create table task_Escalation (
        id number(19,0) not null,
        name varchar2(255),
        Deadline_Escalation_Id number(19,0),
        primary key (id)
    );

    create table task_I18NText (
        id number(19,0) not null,
        language varchar2(255),
        text clob,
        Task_Subjects_Id number(19,0),
        Task_Names_Id number(19,0),
        Task_Descriptions_Id number(19,0),
        Reassignment_Documentation_Id number(19,0),
        Notification_Subjects_Id number(19,0),
        Notification_Names_Id number(19,0),
        Notification_Documentation_Id number(19,0),
        Notification_Descriptions_Id number(19,0),
        Deadline_Documentation_Id number(19,0),
        primary key (id)
    );

    create table task_Notification (
        DTYPE varchar2(31) not null,
        id number(19,0) not null,
        priority number(10,0) not null,
        Escalation_Notifications_Id number(19,0),
        primary key (id)
    );

    create table task_Notification_BusinessAdministrators (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_Notification_Recipients (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_OrganizationalEntity (
        DTYPE varchar2(31) not null,
        id varchar2(255) not null,
        primary key (id)
    );

    create table task_PeopleAssignments_BusinessAdministrators (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_PeopleAssignments_ExcludedOwners (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_PeopleAssignments_PotentialOwners (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_PeopleAssignments_Recipients (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_PeopleAssignments_TaskStakeholders (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_Reassignment (
        id number(19,0) not null,
        Escalation_Reassignments_Id number(19,0),
        primary key (id)
    );

    create table task_Reassignment_potentialOwners (
        task_id number(19,0) not null,
        entity_id varchar2(255) not null
    );

    create table task_SubTasksStrategy (
        DTYPE varchar2(100) not null,
        id number(19,0) not null,
        name varchar2(255),
        Task_Id number(19,0),
        primary key (id)
    );

    create table task_Task (
        id number(19,0) not null,
        allowedToDelegate varchar2(255),
        priority number(10,0) not null,
        activationTime date,
        createdOn date,
        documentAccessType number(10,0),
        documentContentId number(19,0) not null,
        documentType varchar2(255),
        expirationTime date,
        faultAccessType number(10,0),
        faultContentId number(19,0) not null,
        faultName varchar2(255),
        faultType varchar2(255),
        outputAccessType number(10,0),
        outputContentId number(19,0) not null,
        outputType varchar2(255),
        parentId number(19,0) not null,
        previousStatus number(10,0),
        skipable number(1,0) not null,
        status varchar2(255),
        workItemId number(19,0) not null,
        taskInitiator varchar2(255),
        actualOwner varchar2(255),
        createdBy varchar2(255),
        primary key (id)
    );

    create table task_emailHeaders (
        Notification number(19,0) not null,
        emailHeaders number(19,0) not null,
        emailHeaders_KEY varchar2(255),
        primary key (Notification, emailHeaders_KEY),
        unique (emailHeaders)
    );

    alter table task_Attachment 
        add constraint FKEB39203D839A1819 
        foreign key (TaskData_Attachments_Id) 
        references task_Task;

    alter table task_Attachment 
        add constraint FKEB39203DAEC9B7C0 
        foreign key (attachedBy) 
        references task_OrganizationalEntity;

    alter table task_BooleanExpression 
        add constraint FK946CB08653CF60BD 
        foreign key (Escalation_Constraints_Id) 
        references task_Escalation;

    alter table task_Comment 
        add constraint FKC52D0D85DF67B41C 
        foreign key (addedBy) 
        references task_OrganizationalEntity;

    alter table task_Comment 
        add constraint FKC52D0D8544E05A35 
        foreign key (TaskData_Comments_Id) 
        references task_Task;

    alter table task_Deadline 
        add constraint FK22619FF2F9CD9DE3 
        foreign key (Deadlines_StartDeadLine_Id) 
        references task_Task;

    alter table task_Deadline 
        add constraint FK22619FF2B92DDCCA 
        foreign key (Deadlines_EndDeadLine_Id) 
        references task_Task;

    alter table task_Delegation_delegates 
        add constraint FKE4B257D1B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_Delegation_delegates 
        add constraint FKE4B257D1C834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_Escalation 
        add constraint FK5122B1AFF8479DB0 
        foreign key (Deadline_Escalation_Id) 
        references task_Deadline;

    alter table task_I18NText 
        add constraint FK23CBC9E51F7F90F4 
        foreign key (Notification_Descriptions_Id) 
        references task_Notification;

    alter table task_I18NText 
        add constraint FK23CBC9E5D2A5802B 
        foreign key (Notification_Names_Id) 
        references task_Notification;

    alter table task_I18NText 
        add constraint FK23CBC9E55D086819 
        foreign key (Reassignment_Documentation_Id) 
        references task_Reassignment;

    alter table task_I18NText 
        add constraint FK23CBC9E563D84819 
        foreign key (Deadline_Documentation_Id) 
        references task_Deadline;

    alter table task_I18NText 
        add constraint FK23CBC9E57E635379 
        foreign key (Notification_Documentation_Id) 
        references task_Notification;

    alter table task_I18NText 
        add constraint FK23CBC9E5FB341028 
        foreign key (Task_Descriptions_Id) 
        references task_Task;

    alter table task_I18NText 
        add constraint FK23CBC9E5447C5C58 
        foreign key (Task_Subjects_Id) 
        references task_Task;

    alter table task_I18NText 
        add constraint FK23CBC9E5921AA76B 
        foreign key (Task_Names_Id) 
        references task_Task;

    alter table task_I18NText 
        add constraint FK23CBC9E5F76F8024 
        foreign key (Notification_Subjects_Id) 
        references task_Notification;

    alter table task_Notification 
        add constraint FK7A66F185A7F88A4B 
        foreign key (Escalation_Notifications_Id) 
        references task_Escalation;

    alter table task_Notification_BusinessAdministrators 
        add constraint FK3734740B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_Notification_BusinessAdministrators 
        add constraint FK37347409A939BFA 
        foreign key (task_id) 
        references task_Notification;

    alter table task_Notification_Recipients 
        add constraint FK8D05C94B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_Notification_Recipients 
        add constraint FK8D05C949A939BFA 
        foreign key (task_id) 
        references task_Notification;

    alter table task_PeopleAssignments_BusinessAdministrators 
        add constraint FK6CE4A4E8B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_PeopleAssignments_BusinessAdministrators 
        add constraint FK6CE4A4E8C834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_PeopleAssignments_ExcludedOwners 
        add constraint FK7FCD224CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_PeopleAssignments_ExcludedOwners 
        add constraint FK7FCD224CC834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_PeopleAssignments_PotentialOwners 
        add constraint FKC6A865CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_PeopleAssignments_PotentialOwners 
        add constraint FKC6A865CC834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_PeopleAssignments_Recipients 
        add constraint FK6862F63CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_PeopleAssignments_Recipients 
        add constraint FK6862F63CC834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_PeopleAssignments_TaskStakeholders 
        add constraint FK70969CF4B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_PeopleAssignments_TaskStakeholders 
        add constraint FK70969CF4C834E294 
        foreign key (task_id) 
        references task_Task;

    alter table task_Reassignment 
        add constraint FKBF6E19DA49D98020 
        foreign key (Escalation_Reassignments_Id) 
        references task_Escalation;

    alter table task_Reassignment_potentialOwners 
        add constraint FK32227D79B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity;

    alter table task_Reassignment_potentialOwners 
        add constraint FK32227D79DF9AC44F 
        foreign key (task_id) 
        references task_Reassignment;

    alter table task_SubTasksStrategy 
        add constraint FKD38C3A5BC834E294 
        foreign key (Task_Id) 
        references task_Task;

    alter table task_Task 
        add constraint FKAB9D81F47807804 
        foreign key (createdBy) 
        references task_OrganizationalEntity;

    alter table task_Task 
        add constraint FKAB9D81F79AC18AA 
        foreign key (actualOwner) 
        references task_OrganizationalEntity;

    alter table task_Task 
        add constraint FKAB9D81F101BF90F 
        foreign key (taskInitiator) 
        references task_OrganizationalEntity;

    alter table task_emailHeaders 
        add constraint FK811BC8C48E1432D8 
        foreign key (Notification) 
        references task_Notification;

    alter table task_emailHeaders 
        add constraint FK811BC8C49B77AF44 
        foreign key (emailHeaders) 
        references task_EmailNotificationHeader;

