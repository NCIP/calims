
    create table task_Attachment (
        id bigint not null auto_increment,
        accessType integer,
        attachedAt datetime,
        attachmentContentId bigint not null,
        contentType varchar(255),
        name varchar(255),
        size integer not null,
        attachedBy varchar(255),
        TaskData_Attachments_Id bigint,
        primary key (id)
    );

    create table task_BooleanExpression (
        id bigint not null auto_increment,
        expression longtext,
        type varchar(255),
        Escalation_Constraints_Id bigint,
        primary key (id)
    );

    create table task_Comment (
        id bigint not null auto_increment,
        addedAt datetime,
        text longtext,
        addedBy varchar(255),
        TaskData_Comments_Id bigint,
        primary key (id)
    );

    create table task_Content (
        id bigint not null auto_increment,
        content longblob,
        primary key (id)
    );

    create table task_Deadline (
        id bigint not null auto_increment,
        date datetime,
        escalated bit not null,
        Deadlines_StartDeadLine_Id bigint,
        Deadlines_EndDeadLine_Id bigint,
        primary key (id)
    );

    create table task_Delegation_delegates (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_EmailNotificationHeader (
        id bigint not null auto_increment,
        body longtext,
        fromAddress varchar(255),
        language varchar(255),
        replyToAddress varchar(255),
        subject varchar(255),
        primary key (id)
    );

    create table task_Escalation (
        id bigint not null auto_increment,
        name varchar(255),
        Deadline_Escalation_Id bigint,
        primary key (id)
    );

    create table task_I18NText (
        id bigint not null auto_increment,
        language varchar(255),
        text longtext,
        Task_Subjects_Id bigint,
        Task_Names_Id bigint,
        Task_Descriptions_Id bigint,
        Reassignment_Documentation_Id bigint,
        Notification_Subjects_Id bigint,
        Notification_Names_Id bigint,
        Notification_Documentation_Id bigint,
        Notification_Descriptions_Id bigint,
        Deadline_Documentation_Id bigint,
        primary key (id)
    );

    create table task_Notification (
        DTYPE varchar(31) not null,
        id bigint not null auto_increment,
        priority integer not null,
        Escalation_Notifications_Id bigint,
        primary key (id)
    );

    create table task_Notification_BusinessAdministrators (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_Notification_Recipients (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_OrganizationalEntity (
        DTYPE varchar(31) not null,
        id varchar(255) not null,
        primary key (id)
    );

    create table task_PeopleAssignments_BusinessAdministrators (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_PeopleAssignments_ExcludedOwners (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_PeopleAssignments_PotentialOwners (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_PeopleAssignments_Recipients (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_PeopleAssignments_TaskStakeholders (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_Reassignment (
        id bigint not null auto_increment,
        Escalation_Reassignments_Id bigint,
        primary key (id)
    );

    create table task_Reassignment_potentialOwners (
        task_id bigint not null,
        entity_id varchar(255) not null
    );

    create table task_SubTasksStrategy (
        DTYPE varchar(100) not null,
        id bigint not null auto_increment,
        name varchar(255),
        Task_Id bigint,
        primary key (id)
    );

    create table task_Task (
        id bigint not null auto_increment,
        allowedToDelegate varchar(255),
        priority integer not null,
        activationTime datetime,
        createdOn datetime,
        documentAccessType integer,
        documentContentId bigint not null,
        documentType varchar(255),
        expirationTime datetime,
        faultAccessType integer,
        faultContentId bigint not null,
        faultName varchar(255),
        faultType varchar(255),
        outputAccessType integer,
        outputContentId bigint not null,
        outputType varchar(255),
        parentId bigint not null,
        previousStatus integer,
        skipable bit not null,
        status varchar(255),
        workItemId bigint not null,
        taskInitiator varchar(255),
        actualOwner varchar(255),
        createdBy varchar(255),
        primary key (id)
    );

    create table task_emailHeaders (
        Notification bigint not null,
        emailHeaders bigint not null,
        emailHeaders_KEY varchar(255),
        primary key (Notification, emailHeaders_KEY),
        unique (emailHeaders)
    );

    alter table task_Attachment 
        add index FKEB39203D839A1819 (TaskData_Attachments_Id), 
        add constraint FKEB39203D839A1819 
        foreign key (TaskData_Attachments_Id) 
        references task_Task (id);

    alter table task_Attachment 
        add index FKEB39203DAEC9B7C0 (attachedBy), 
        add constraint FKEB39203DAEC9B7C0 
        foreign key (attachedBy) 
        references task_OrganizationalEntity (id);

    alter table task_BooleanExpression 
        add index FK946CB08653CF60BD (Escalation_Constraints_Id), 
        add constraint FK946CB08653CF60BD 
        foreign key (Escalation_Constraints_Id) 
        references task_Escalation (id);

    alter table task_Comment 
        add index FKC52D0D85DF67B41C (addedBy), 
        add constraint FKC52D0D85DF67B41C 
        foreign key (addedBy) 
        references task_OrganizationalEntity (id);

    alter table task_Comment 
        add index FKC52D0D8544E05A35 (TaskData_Comments_Id), 
        add constraint FKC52D0D8544E05A35 
        foreign key (TaskData_Comments_Id) 
        references task_Task (id);

    alter table task_Deadline 
        add index FK22619FF2F9CD9DE3 (Deadlines_StartDeadLine_Id), 
        add constraint FK22619FF2F9CD9DE3 
        foreign key (Deadlines_StartDeadLine_Id) 
        references task_Task (id);

    alter table task_Deadline 
        add index FK22619FF2B92DDCCA (Deadlines_EndDeadLine_Id), 
        add constraint FK22619FF2B92DDCCA 
        foreign key (Deadlines_EndDeadLine_Id) 
        references task_Task (id);

    alter table task_Delegation_delegates 
        add index FKE4B257D1B009A012 (entity_id), 
        add constraint FKE4B257D1B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_Delegation_delegates 
        add index FKE4B257D1C834E294 (task_id), 
        add constraint FKE4B257D1C834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_Escalation 
        add index FK5122B1AFF8479DB0 (Deadline_Escalation_Id), 
        add constraint FK5122B1AFF8479DB0 
        foreign key (Deadline_Escalation_Id) 
        references task_Deadline (id);

    alter table task_I18NText 
        add index FK23CBC9E51F7F90F4 (Notification_Descriptions_Id), 
        add constraint FK23CBC9E51F7F90F4 
        foreign key (Notification_Descriptions_Id) 
        references task_Notification (id);

    alter table task_I18NText 
        add index FK23CBC9E5D2A5802B (Notification_Names_Id), 
        add constraint FK23CBC9E5D2A5802B 
        foreign key (Notification_Names_Id) 
        references task_Notification (id);

    alter table task_I18NText 
        add index FK23CBC9E55D086819 (Reassignment_Documentation_Id), 
        add constraint FK23CBC9E55D086819 
        foreign key (Reassignment_Documentation_Id) 
        references task_Reassignment (id);

    alter table task_I18NText 
        add index FK23CBC9E563D84819 (Deadline_Documentation_Id), 
        add constraint FK23CBC9E563D84819 
        foreign key (Deadline_Documentation_Id) 
        references task_Deadline (id);

    alter table task_I18NText 
        add index FK23CBC9E57E635379 (Notification_Documentation_Id), 
        add constraint FK23CBC9E57E635379 
        foreign key (Notification_Documentation_Id) 
        references task_Notification (id);

    alter table task_I18NText 
        add index FK23CBC9E5FB341028 (Task_Descriptions_Id), 
        add constraint FK23CBC9E5FB341028 
        foreign key (Task_Descriptions_Id) 
        references task_Task (id);

    alter table task_I18NText 
        add index FK23CBC9E5447C5C58 (Task_Subjects_Id), 
        add constraint FK23CBC9E5447C5C58 
        foreign key (Task_Subjects_Id) 
        references task_Task (id);

    alter table task_I18NText 
        add index FK23CBC9E5921AA76B (Task_Names_Id), 
        add constraint FK23CBC9E5921AA76B 
        foreign key (Task_Names_Id) 
        references task_Task (id);

    alter table task_I18NText 
        add index FK23CBC9E5F76F8024 (Notification_Subjects_Id), 
        add constraint FK23CBC9E5F76F8024 
        foreign key (Notification_Subjects_Id) 
        references task_Notification (id);

    alter table task_Notification 
        add index FK7A66F185A7F88A4B (Escalation_Notifications_Id), 
        add constraint FK7A66F185A7F88A4B 
        foreign key (Escalation_Notifications_Id) 
        references task_Escalation (id);

    alter table task_Notification_BusinessAdministrators 
        add index FK3734740B009A012 (entity_id), 
        add constraint FK3734740B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_Notification_BusinessAdministrators 
        add index FK37347409A939BFA (task_id), 
        add constraint FK37347409A939BFA 
        foreign key (task_id) 
        references task_Notification (id);

    alter table task_Notification_Recipients 
        add index FK8D05C94B009A012 (entity_id), 
        add constraint FK8D05C94B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_Notification_Recipients 
        add index FK8D05C949A939BFA (task_id), 
        add constraint FK8D05C949A939BFA 
        foreign key (task_id) 
        references task_Notification (id);

    alter table task_PeopleAssignments_BusinessAdministrators 
        add index FK6CE4A4E8B009A012 (entity_id), 
        add constraint FK6CE4A4E8B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_PeopleAssignments_BusinessAdministrators 
        add index FK6CE4A4E8C834E294 (task_id), 
        add constraint FK6CE4A4E8C834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_PeopleAssignments_ExcludedOwners 
        add index FK7FCD224CB009A012 (entity_id), 
        add constraint FK7FCD224CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_PeopleAssignments_ExcludedOwners 
        add index FK7FCD224CC834E294 (task_id), 
        add constraint FK7FCD224CC834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_PeopleAssignments_PotentialOwners 
        add index FKC6A865CB009A012 (entity_id), 
        add constraint FKC6A865CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_PeopleAssignments_PotentialOwners 
        add index FKC6A865CC834E294 (task_id), 
        add constraint FKC6A865CC834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_PeopleAssignments_Recipients 
        add index FK6862F63CB009A012 (entity_id), 
        add constraint FK6862F63CB009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_PeopleAssignments_Recipients 
        add index FK6862F63CC834E294 (task_id), 
        add constraint FK6862F63CC834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_PeopleAssignments_TaskStakeholders 
        add index FK70969CF4B009A012 (entity_id), 
        add constraint FK70969CF4B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_PeopleAssignments_TaskStakeholders 
        add index FK70969CF4C834E294 (task_id), 
        add constraint FK70969CF4C834E294 
        foreign key (task_id) 
        references task_Task (id);

    alter table task_Reassignment 
        add index FKBF6E19DA49D98020 (Escalation_Reassignments_Id), 
        add constraint FKBF6E19DA49D98020 
        foreign key (Escalation_Reassignments_Id) 
        references task_Escalation (id);

    alter table task_Reassignment_potentialOwners 
        add index FK32227D79B009A012 (entity_id), 
        add constraint FK32227D79B009A012 
        foreign key (entity_id) 
        references task_OrganizationalEntity (id);

    alter table task_Reassignment_potentialOwners 
        add index FK32227D79DF9AC44F (task_id), 
        add constraint FK32227D79DF9AC44F 
        foreign key (task_id) 
        references task_Reassignment (id);

    alter table task_SubTasksStrategy 
        add index FKD38C3A5BC834E294 (Task_Id), 
        add constraint FKD38C3A5BC834E294 
        foreign key (Task_Id) 
        references task_Task (id);

    alter table task_Task 
        add index FKAB9D81F47807804 (createdBy), 
        add constraint FKAB9D81F47807804 
        foreign key (createdBy) 
        references task_OrganizationalEntity (id);

    alter table task_Task 
        add index FKAB9D81F79AC18AA (actualOwner), 
        add constraint FKAB9D81F79AC18AA 
        foreign key (actualOwner) 
        references task_OrganizationalEntity (id);

    alter table task_Task 
        add index FKAB9D81F101BF90F (taskInitiator), 
        add constraint FKAB9D81F101BF90F 
        foreign key (taskInitiator) 
        references task_OrganizationalEntity (id);

    alter table task_emailHeaders 
        add index FK811BC8C48E1432D8 (Notification), 
        add constraint FK811BC8C48E1432D8 
        foreign key (Notification) 
        references task_Notification (id);

    alter table task_emailHeaders 
        add index FK811BC8C49B77AF44 (emailHeaders), 
        add constraint FK811BC8C49B77AF44 
        foreign key (emailHeaders) 
        references task_EmailNotificationHeader (id);
