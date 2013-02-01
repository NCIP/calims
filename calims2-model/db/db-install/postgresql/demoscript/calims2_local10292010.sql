create sequence hibernate_sequence;

        create table ACCOUNT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE bytea not null,
        STARTDATE bytea not null,
        STATUS varchar(100) not null,
        LABORATORY_FK int8 not null,
        ORGANIZATION_FK int8 not null,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table ACCOUNTNUMBER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp not null,
        STARTDATE timestamp not null,
        STATUS varchar(100) not null,
        VALUE int8 not null,
        ACCOUNT_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table ADAPTER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK int8,
        FILEFORMATSPECIFICATION_FK int8,
        DOCUMENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table ADDITIONALORGANISMNAME (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMMENT varchar(100),
        CONTENT varchar(100),
        DATEASSIGNED bytea,
        ISCURRENTNAME bool,
        SOURCE varchar(100),
        TYPE_FK int8,
        WHOLEORGANISM_FK int8,
        primary key (id)
    );

    create table ANTIBODY (
        COUNTOFREQUESTS int4,
        ISOTYPE varchar(100),
        RECOMMENDEDDILUTIONRANGE varchar(100),
        ID int8 not null,
        ANTIGEN_FK int8,
        primary key (ID)
    );

    create table ANTIGEN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COUNTOFREQUESTS int8,
        USE varchar(100),
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table ARTIFICIALSPECIMEN (
        ID int8 not null,
        primary key (ID)
    );

    create table BASEUNIT (
        ID int8 not null,
        primary key (ID)
    );

    create table BILLINGINFORMATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATE timestamp,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table BIOHAZARD (
        ID int8 not null,
        primary key (ID)
    );

    create table BIOSPECIMEN (
        ID int8 not null,
        TAXON_FK int8,
        TYPE_FK int8,
        primary key (ID)
    );

    create table CARBOHYDRATE (
        CHEMICALFORMULA varchar(100),
        ORIENTATION varchar(100),
        POLYSACCHARIDEREPEATPATTERN varchar(100),
        POLYSACCHARIDEUNIT varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table CELLSPECIMEN (
        CELLCULTUREGROWTHMEDIUM varchar(100),
        CELLCULTUREGROWTHMEDIUMSUPPLE varchar(100),
        COUNTOFREQUESTS int4,
        MYCOPLASMASTATUS varchar(100),
        PASSAGENUMBER int4,
        TARGETEDMUTATION varchar(100),
        ID int8 not null,
        CONTAINER_FK int8,
        primary key (ID)
    );

    create table CHEMICALCOMPOUND (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        NDCCODE varchar(100),
        CHEMICALFORMULA varchar(100),
        EXPIRATIONDATE timestamp,
        CONTAINER_FK int8,
        NANOMATERIAL_FK int8,
        primary key (id)
    );

    create table COLLABORATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        ROLE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table CONTACTINFORMATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        EMAILADDRESS varchar(100),
        RANK int4 not null,
        STATUS varchar(100) not null,
        COLLABORATION_FK int8,
        LABORATORY_FK int8,
        LOCATION_FK int8,
        ORGANIZATION_FK int8,
        PERSON_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table CONTAINER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X int4,
        Y int4,
        ISREUSABLE bool,
        ISTEMPLATE bool,
        STATUS varchar(100),
        CONTAINERTYPE_FK int8,
        FILLPATTERN_FK int8,
        LAYOUT_FK int8,
        LOCATION_FK int8,
        CONTAINER_FK int8,
        primary key (id)
    );

    create table CONTAINERSUBCATEGORY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK int8,
        primary key (id)
    );

    create table CONTAINERTYPE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPOSITION varchar(100),
        CONTAINERTYPE_FK int8,
        CONTAINERSUBCATEGORY_FK int8,
        LAYOUT_FK int8,
        primary key (id)
    );

    create table CONTRACT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table COORDINATE_FILLPATTERN (
        ID_COORDINATE_FILLPATTERN int8 not null,
        X int4,
        Y int4,
        LIST_INDEX int4 not null,
        primary key (ID_COORDINATE_FILLPATTERN, LIST_INDEX)
    );

    create table CUSTOMERREQUEST (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMPLETEDDATE timestamp,
        INVOICEDATE timestamp,
        LABORATORYFINALAPPROVEDATE timestamp,
        PAYMENTDATE timestamp,
        STATUS varchar(100) not null,
        SUBMISSIONDATE timestamp,
        ACCOUNT_FK int8,
        PERSON_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table Characteristics (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ISQUANTITATIVE bool,
        VALUE varchar(100),
        QUANTITY_VALUE varchar(100),
        DATE timestamp,
        AFFECTEDPERSON varchar(100),
        GENOTYPESEX varchar(100),
        PHENOTYPESEX varchar(100),
        PERSON_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        ANTIGEN_FK int8,
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        COATCOLOR_FK int8,
        CHEMICALCOMPOUND_FK int8,
        SEQUENCE_FK int8,
        NUCLEICACID_FK int8,
        primary key (id)
    );

    create table Collaboration_Laboratory (
        COLLABORATION_ID int8 not null,
        LABORATORY_ID int8 not null,
        primary key (COLLABORATION_ID, LABORATORY_ID)
    );

    create table Collaboration_Person (
        COLLABORATION_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (COLLABORATION_ID, PERSON_ID)
    );

    create table ContainerType_Layout (
        LAYOUT_ID int8 not null,
        CONTAINERTYPE_ID int8 not null,
        primary key (CONTAINERTYPE_ID, LAYOUT_ID)
    );

    create table CustomerRequest_Service (
        CUSTOMERREQUEST_ID int8 not null,
        SERVICE_ID int8 not null,
        primary key (CUSTOMERREQUEST_ID, SERVICE_ID)
    );

    create table DOCUMENT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDPAGE varchar(100),
        KEYWORDCODE varchar(100),
        KEYWORDTEXT varchar(100),
        STARTPAGE varchar(100),
        STATUS varchar(100) not null,
        TITLE varchar(100),
        UNIVERSALRESOURCELOCATOR varchar(100),
        VERSION varchar(100),
        ACCOUNT_FK int8,
        BIOSPECIMEN_FK int8,
        CHARACTERISTICS_FK int8,
        CHEMICALCOMPOUND_FK int8,
        COLLABORATION_FK int8,
        CONTRACT_FK int8,
        CUSTOMERREQUEST_FK int8,
        EQUIPMENT_FK int8,
        EVENT_FK int8,
        FILEFORMATSPECIFICATION_FK int8,
        HAZARD_FK int8,
        INVOICE_FK int8,
        LABSUPPLY_FK int8,
        LOCATION_FK int8,
        NAMINGCONVENTION_FK int8,
        ORGANIZATION_FK int8,
        PERSON_FK int8,
        QUOTATION_FK int8,
        SERVICE_FK int8,
        SPECIMEN_FK int8,
        UNIT_FK int8,
        WORKSHEET_FK int8,
        primary key (id)
    );

    create table ELECTRONICDOCUMENT (
        DIGITALOBJECTIDENTIFIER varchar(100),
        ID int8 not null,
        FILEFORMATSPECIFICATION_FK int8,
        STORAGESPACE_FK int8,
        EQUIPMENT_FK int8,
        primary key (ID)
    );

    create table EQUIPMENT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MODEL varchar(100),
        PROPERTYID varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        LABORATORY_FK int8 not null,
        LOCATION_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table EXTERNALIDENTIFIER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOURCE varchar(100),
        VALUE varchar(100),
        ACCOUNT_FK int8,
        CUSTOMERREQUEST_FK int8,
        LABSUPPLY_FK int8,
        PERSON_FK int8,
        SEQUENCE_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table EXTERNALIDENTIFIER_SEQUEN (
        ID_EXTERNALIDENTIFIER_SEQ int8 not null,
        externalIdentifierCollection_id int8 not null,
        primary key (ID_EXTERNALIDENTIFIER_SEQ, externalIdentifierCollection_id),
        unique (externalIdentifierCollection_id)
    );

    create table EnvironmentalCondition (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        MAXIMUMHUMIDITY varchar(100),
        MEASUREDHUMIDITY varchar(100),
        MINIMUMHUMIDITY varchar(100),
        MAXIMUMTEMPERATURE float4,
        MEASUREDTEMPERATURE float4,
        MINIMUMTEMPERATURE float4,
        MAXIMUMPH int8,
        MEASUREDPH int8,
        MINIMUMPH int8,
        MAXIMUMPERCENTCO2 float4,
        MEASUREDPERCENTCO2 float4,
        MINIMUMPERCENTCO2 float4,
        MAXIMUMPERCENTO2 float4,
        MEASUREDPERCENTO2 float4,
        MINIMUMPERCENTO2 float4,
        EVENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table Equipment_Hazard (
        EQUIPMENT_ID int8 not null,
        HAZARD_ID int8 not null,
        primary key (EQUIPMENT_ID, HAZARD_ID)
    );

    create table Equipment_Organization (
        EQUIPMENT_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (EQUIPMENT_ID, ORGANIZATION_ID)
    );

    create table Equipment_Person (
        EQUIPMENT_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (EQUIPMENT_ID, PERSON_ID)
    );

    create table Event (
        entitytype varchar(30) not null,
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(100),
        DISPLAYNAME varchar(100),
        NAME varchar(100),
        CONTAINER_FK int8,
        LABSUPPLY_FK int8,
        LOCATION_FK int8,
        PERSON_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        WHOLEORGANISM_FK int8,
        ORGANIZATION_FK int8,
        primary key (id)
    );

    create table FEATURE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SEQUENCEEND int8,
        SEQUENCESTART int8,
        SITE varchar(100),
        ANTIGEN_FK int8,
        TYPE_FK int8,
        SPECIMEN_FK int8,
        FEATURECOLLECTION_FK int8,
        primary key (id)
    );

    create table FILEEXTENSION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VALUE varchar(100),
        ELECTRONICDOCUMENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table FILEFORMATSPECIFICATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        PERSON_FK int8,
        FILEEXTENSION_FK int8,
        FILETRANSPORTER_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table FILETRANSPORTER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        primary key (id)
    );

    create table FILLPATTERN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        PERSON_FK int8,
        LAYOUT_FK int8,
        primary key (id)
    );

    create table FLUIDSPECIMEN (
        PREPARATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table HAZARD (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTAINER_FK int8,
        LABSUPPLY_FK int8,
        SPECIMEN_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table INQUIRY (
        EXPIRATIONDATE timestamp,
        INQUIRYSUBMISSIONDATE timestamp,
        ID int8 not null,
        TYPE_FK int8,
        primary key (ID)
    );

    create table INVOICE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        INVOICEDATE timestamp,
        INVOICEPAYMENTDATE timestamp,
        STATUS varchar(100) not null,
        CUSTOMERREQUEST_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table Invoice_Organization (
        INVOICE_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (INVOICE_ID, ORGANIZATION_ID)
    );

    create table LABORATORY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        LOCATION_FK int8,
        primary key (id)
    );

    create table LABSUPPLY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE bytea,
        STATUS varchar(100),
        CONTAINER_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table LAYOUT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        X_DIMENSION int4,
        X_DIMENSIONLABEL varchar(100) not null,
        Y_DIMENSION int4,
        Y_DIMENSIONLABEL varchar(100) not null,
        PERSON_FK int8,
        primary key (id)
    );

    create table LIPID (
        CATEGORY varchar(100),
        CHEMICALFORMULA varchar(100),
        DELTAXNOMENCLATURE varchar(100),
        FUNCTION varchar(100),
        NXNOMENCLATURE varchar(100),
        SATURATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table LOCATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        VALUE varchar(100),
        LOCATION_FK int8,
        TYPE_FK int8 not null,
        TRAVELHISTORY_FK int8,
        SPECIMEN_FK int8,
        STORAGESPACE_FK int8,
        primary key (id)
    );

    create table LabSupply_Organization (
        LABSUPPLY_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (LABSUPPLY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Organization (
        LABORATORY_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (LABORATORY_ID, ORGANIZATION_ID)
    );

    create table Laboratory_Person (
        LABORATORY_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (LABORATORY_ID, PERSON_ID)
    );

    create table MOLECULARSPECIMEN (
        ID int8 not null,
        primary key (ID)
    );

    create table NAMINGCONVENTION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXAMPLE varchar(100),
        GROUPING varchar(100),
        ISMANDATORY bool,
        ISSUGGESTED bool,
        ISUNIQUE bool,
        MAXIMUMLENGTH int8,
        STATUS varchar(100) not null,
        TYPE int4 not null,
        PERSON_FK int8,
        LABORATORY_FK int8,
        primary key (id)
    );

    create table NANOMATERIAL (
        ID int8 not null,
        CHEMICALCOMPOUND_FK int8,
        primary key (ID)
    );

    create table NOTES_ACCOUNT (
        ID_NOTES_ACCOUNT int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_ACCOUNTNUMBER (
        ID_NOTES_ACCOUNTNUMBER int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_ADAPTER (
        ID_NOTES_ADAPTER int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_ADDITIONALORGANISMN (
        ID_NOTES_ADDITIONALORGANI int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_BILLINGINFORMATION (
        ID_NOTES_BILLINGINFORMATI int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_CHARACTERISTICS (
        ID_NOTES_CHARACTERISTICS int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_CONTACTINFORMATION (
        ID_NOTES_CONTACTINFORMATI int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_CUSTOMERREQUEST (
        ID_NOTES_CUSTOMERREQUEST int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_EVENT (
        ID_NOTES_EVENT int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_HAZARD (
        ID_NOTES_HAZARD int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_INVOICE (
        ID_NOTES_INVOICE int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_LABSUPPLY (
        ID_NOTES_LABSUPPLY int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_LAYOUT (
        ID_NOTES_LAYOUT int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_PARAMETER (
        ID_NOTES_PARAMETER int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_POSTALADDRESS (
        ID_NOTES_POSTALADDRESS int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_QUOTATION (
        ID_NOTES_QUOTATION int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_RATE (
        ID_NOTES_RATE int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_ROLE (
        ID_NOTES_ROLE int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SAFETYCAUTION (
        ID_NOTES_SAFETYCAUTION int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SERVICE (
        ID_NOTES_SERVICE int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SERVICEITEM (
        ID_NOTES_SERVICEITEM int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SOFTWARE (
        ID_NOTES_SOFTWARE int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SOP (
        ID_NOTES_SOP int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_SPECIMEN (
        ID_NOTES_SPECIMEN int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_STRAIN (
        ID_NOTES_STRAIN int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NOTES_TAXON (
        ID_NOTES_TAXON int8 not null,
        CONTENT varchar(100),
        STATUS varchar(100)
    );

    create table NUCLEICACID (
        ID int8 not null,
        primary key (ID)
    );

    create table ORGANIZATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DUNSNUMBER varchar(100),
        IDENTIFIERNUMBER varchar(100),
        ISTAXEXEMPT bool,
        LEGALCATEGORYTYPE varchar(100),
        STATUS varchar(100) not null,
        TAXIDENTIFIERNUMBER varchar(100),
        LOCATION_FK int8,
        ORGANIZATION_FK int8,
        TYPE_FK int8 not null,
        COLLABORATION_FK int8,
        primary key (id)
    );

    create table PARAMETER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        SPECIMEN_FK int8,
        TYPE_FK int8,
        SOFTWARE_FK int8,
        primary key (id)
    );

    create table PCRPRODUCT (
        EXPECTEDSIZE int8,
        OBSERVEDSIZE int8,
        ID int8 not null,
        FORWARDPRIMER_FK int8,
        REVERSEPRIMER_FK int8,
        primary key (ID)
    );

    create table PERSON (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        USMILITARYRANKPREFIX varchar(100),
        ACADEMICDEGREE varchar(100),
        CERTIFICATION varchar(100),
        CLINICALLICENSE varchar(100),
        DISPLAYNAME varchar(100),
        FAMILYNAME varchar(100),
        GIVENNAME varchar(100),
        INDIVIDUALGENEOLOGYSUFFIX varchar(100),
        MAIDENNAME varchar(100),
        MIDDLENAME varchar(100),
        NAMEPREFIX varchar(100),
        STATUS varchar(100) not null,
        SUFFIX varchar(100),
        TITLE varchar(100),
        TRAININGANDEDUCATIONSUFFIXABR varchar(100),
        USERNAME varchar(100),
        EXTERNALIDENTIFIER_FK int8,
        PERSONBILLINGINFORMATION_FK int8,
        SERVICEITEMBILLINGINFORMATION_FK int8,
        SPECIMEN_FK int8,
        LABSUPPLY_FK int8,
        primary key (id)
    );

    create table POSTALADDRESS (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ADDRESSSTREETPOSTDIRECTIONALT varchar(100),
        ADDRESSSTREETPREDIRECTIONALTY varchar(100),
        CITY varchar(100),
        COUNTRY varchar(100),
        COUNTY varchar(100),
        FIRSTADDRESSLINE varchar(100),
        MAILSTOPCODE varchar(100),
        POSTOFFICEBOXNUMBER varchar(100),
        POSTALCODE varchar(100),
        SECONDADDRESSLINE varchar(100),
        STATE varchar(100),
        STATUS varchar(100) not null,
        CONTACTINFORMATION_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table PRIMER (
        ID int8 not null,
        primary key (ID)
    );

    create table PROTEIN (
        CLASSGROUP varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table Person_Organization (
        PERSON_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (PERSON_ID, ORGANIZATION_ID)
    );

    create table QUANTITY_CENTRIFUGATIONEV (
        ID_QUANTITY_CENTRIFUGATIO int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_CONTAINER (
        ID_QUANTITY_CONTAINER int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_ENVIRONMENTALCON (
        ID_QUANTITY_ENVIRONMENTAL int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_LABSUPPLY (
        ID_QUANTITY_LABSUPPLY int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUANTITY_SPECIMEN (
        ID_QUANTITY_SPECIMEN int8 not null,
        STANDARDUNIT_FK int8,
        TYPE_FK int8,
        VALUE varchar(100)
    );

    create table QUERY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATEMENT varchar(100),
        REPORT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table QUOTATION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        APPROVALDATE timestamp,
        EXPIRATIONDATE timestamp,
        QUANTITY_VALUE varchar(100),
        STATUS varchar(100) not null,
        QUANTITY_STANDARDUNIT_FK int8,
        QUANTITY_TYPE_FK int8,
        RATE_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table RATE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        QUANTITY int8,
        STATUS varchar(100) not null,
        PERSON_FK int8,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table REPORT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        VERSION varchar(100),
        ACCOUNT_FK int8,
        INVOICE_FK int8,
        primary key (id)
    );

    create table ROLE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        TYPE int4 not null,
        PERSON_FK int8,
        ORGANIZATION_FK int8,
        LABORATORY_FK int8,
        primary key (id)
    );

    create table SAFETYCAUTION (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HAZARD_FK int8,
        primary key (id)
    );

    create table SEQUENCE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        URI varchar(100),
        ASCIIREPRESENTATION varchar(100),
        PARENTENDOFFSET int8,
        PARENTSTARTOFFSET int8,
        STRAND varchar(100),
        ANTIBODY_FK int8,
        ANTIGEN_FK int8,
        CTERMINUS_FK int8,
        PHYSICALCHARACTERISTICS_FK int8,
        NTERMINUS_FK int8,
        NUCLEICACID_FK int8,
        PROTEIN_FK int8,
        primary key (id)
    );

    create table SERVICE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp,
        STARTDATE timestamp,
        STATUS varchar(100) not null,
        TYPE_FK int8 not null,
        primary key (id)
    );

    create table SERVICEITEM (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ENDDATE timestamp,
        QUANTITY int8,
        STARTDATE timestamp,
        STATUS varchar(100) not null,
        BILLINGINFORMATION_FK int8,
        QUOTATION_FK int8,
        SERVICE_FK int8,
        RATE_FK int8,
        TYPE_FK int8 not null,
        INVOICE_FK int8,
        primary key (id)
    );

    create table SMALLMOLECULE (
        CHEMICALFORMULA varchar(100),
        MECHANISMOFACTION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table SOFTWARE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        EXPIRATIONDATE timestamp,
        NUMBEROFUSERS int4,
        OPERATINGSYSTEM varchar(100),
        SERIALNUMBER varchar(100),
        STATUS varchar(100) not null,
        VERSION varchar(100),
        TYPE_FK int8 not null,
        EQUIPMENT_FK int8,
        primary key (id)
    );

    create table SOP (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CONTENT varchar(100),
        VERSION varchar(100),
        PERSON_FK int8,
        DOCUMENT_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SPECIMEN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ACTIVITYSTATUS varchar(100),
        CONDITION varchar(100),
        ISAVAILABLE bool,
        RECEIVEDDATETIME timestamp,
        USE varchar(100),
        CONTAINER_FK int8,
        SPECIMEN_FK int8,
        primary key (id)
    );

    create table STANDARDUNIT (
        CONVERSIONFACTOR numeric(19, 2),
        DATASOURCE varchar(100),
        DATATARGET varchar(100),
        OFFSETVALUE numeric(19, 2),
        ID int8 not null,
        BASEUNIT_FK int8,
        primary key (ID)
    );

    create table STORAGEDEVICE (
        ID int8 not null,
        primary key (ID)
    );

    create table STORAGESPACE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        STATUS varchar(100) not null,
        PERSON_FK int8 not null,
        LAYOUT_FK int8,
        TYPE_FK int8 not null,
        STORAGEDEVICE_FK int8,
        primary key (id)
    );

    create table STRAIN (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        ETHNICITY varchar(100),
        ISOLATE varchar(100),
        LINE varchar(100),
        STRAINSUBGROUP varchar(100),
        TAXON_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SUMMARY (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        HEADERLABELLIST varchar(100),
        MAXIMUMCOLUMNCOUNT int8,
        MAXIMUMROWCOUNT int8,
        QUERY_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table SafetyCaution_Document (
        SAFETYCAUTION_ID int8 not null,
        DOCUMENT_ID int8 not null,
        primary key (SAFETYCAUTION_ID, DOCUMENT_ID)
    );

    create table SafetyCaution_Person (
        SAFETYCAUTION_ID int8 not null,
        PERSON_ID int8 not null,
        primary key (SAFETYCAUTION_ID, PERSON_ID)
    );

    create table ServiceItem_AccountNumber (
        SERVICEITEM_ID int8 not null,
        ACCOUNTNUMBER_ID int8 not null,
        primary key (SERVICEITEM_ID, ACCOUNTNUMBER_ID)
    );

    create table Service_CustomerRequest (
        SERVICE_ID int8 not null,
        CUSTOMERREQUEST_ID int8 not null,
        primary key (SERVICE_ID, CUSTOMERREQUEST_ID)
    );

    create table Specimen_Organization (
        SPECIMEN_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (SPECIMEN_ID, ORGANIZATION_ID)
    );

    create table StorageSpace_Organization (
        STORAGESPACE_ID int8 not null,
        ORGANIZATION_ID int8 not null,
        primary key (STORAGESPACE_ID, ORGANIZATION_ID)
    );

    create table TAXON (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        COMMONNAME varchar(100),
        GENUS varchar(100),
        NCBITAXONOMYID varchar(100),
        POPULATIONGROUP varchar(100),
        SPECIES varchar(100),
        SPECIESSUBGROUP varchar(100),
        primary key (id)
    );

    create table TELEPHONENUMBER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        RANK varchar(100),
        STATUS varchar(100) not null,
        TELEPHONENUMBEREXTENSION varchar(100),
        VALUE varchar(100),
        CONTACTINFORMATION_FK int8,
        TYPE_FK int8,
        primary key (id)
    );

    create table TISSUESPECIMEN (
        PREPARATION varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table TYPE (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        DATAELEMENTCOLLECTION varchar(100),
        STATUS varchar(100) not null,
        primary key (id)
    );

    create table UNIFORMRESOURCEIDENTIFIER (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TEXT varchar(100),
        VERSION varchar(100),
        ELECTRONICDOCUMENT_FK int8,
        primary key (id)
    );

    create table UNIT (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        TYPE_FK int8,
        primary key (id)
    );

    create table WHOLEORGANISM (
        COMMONNAME varchar(100),
        ETHNICITYSTRAIN varchar(100),
        ID int8 not null,
        primary key (ID)
    );

    create table WORD (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        CHARACTERSET int4 not null,
        DELIMITER varchar(100),
        ISINCREMENTED bool,
        MAXIMUMLENGTH int4 not null,
        MINIMUMLENGTH int4 not null,
        PADCHARACTER varchar(100),
        RANK int4 not null,
        STATUS varchar(100) not null,
        NAMINGCONVENTION_FK int8,
        primary key (id)
    );

    create table WORKSHEET (
        id int8 not null,
        CREATEDBY varchar(100),
        DATECREATED timestamp,
        DATEMODIFIED timestamp,
        MODIFIEDBY varchar(100),
        DESCRIPTION varchar(250),
        DISPLAYNAME varchar(100) not null,
        NAME varchar(100) not null,
        SOP_FK int8,
        LABSUPPLY_FK int8,
        primary key (id)
    );

--
-- PostgreSQL database dump
--

-- Started on 2010-10-29 14:36:52 EDT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 1860
-- Name: csm_applicati_application__seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_applicati_application__seq', 2, true);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 1864
-- Name: csm_filter_clause_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_filter_clause_seq', 1, false);


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 1866
-- Name: csm_group_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_group_group_id_seq', 6, true);


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 1862
-- Name: csm_mapping_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_mapping_seq', 1, false);


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 1874
-- Name: csm_pg_pe_pg_pe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_pg_pe_pg_pe_id_seq', 5, true);


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 1868
-- Name: csm_privilege_privilege_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_privilege_privilege_id_seq', 7, true);


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 1870
-- Name: csm_protectio_protection_e_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_protectio_protection_e_seq', 7, true);


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 1872
-- Name: csm_protectio_protection_g_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_protectio_protection_g_seq', 5, true);


--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 1876
-- Name: csm_role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_role_role_id_seq', 4, true);


--
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 1878
-- Name: csm_role_priv_role_privile_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_role_priv_role_privile_seq', 4, true);


--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 1880
-- Name: csm_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_user_user_id_seq', 11, true);


--
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 1882
-- Name: csm_user_grou_user_group_i_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_user_grou_user_group_i_seq', 8, true);


--
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 1884
-- Name: csm_user_grou_user_group_r_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_user_grou_user_group_r_seq', 22, true);


--
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 1886
-- Name: csm_user_pe_user_protectio_seq; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('csm_user_pe_user_protectio_seq', 2, true);


--
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 1888
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: dbadmin
--

SELECT pg_catalog.setval('hibernate_sequence', 199564, true);


--
-- TOC entry 3057 (class 0 OID 3742593)
-- Dependencies: 2015
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100000, 'adminuser', '2010-08-17 15:04:04.052', '2010-08-17 21:55:46.069', 'adminuser', '', 'Test Organization Type', 'Test Organization Type', 'ORGANIZATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100039, 'superuser1', '2010-08-20 03:49:49.516', NULL, NULL, 'CI to be used if primary CI not available.', 'Secondary', 'Secondary', 'CONTACTINFORMATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100040, 'superuser1', '2010-08-20 03:50:46.519', NULL, NULL, 'CI to be used in an emergency.', 'Emergency', 'Emergency', 'CONTACTINFORMATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100041, 'superuser1', '2010-08-20 03:54:03.616', NULL, NULL, '', 'Routine', 'Routine', 'CONTACTINFORMATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100038, 'superuser1', '2010-08-20 03:48:45.114', '2010-08-20 04:03:10.323', 'superuser1', 'First CI to be used.', 'Primary', 'Primary', 'CONTACTINFORMATION', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100042, 'superuser1', '2010-08-20 04:05:42.811', NULL, NULL, 'For postal deliveries', 'Mail', 'Mail delivery', 'POSTALADDRESS', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100045, 'superuser1', '2010-08-20 04:09:52.242', NULL, NULL, 'A telephone number that is used for identifying a destination fax machine in a telephone network.', 'Fax', 'Facsimile', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100046, 'superuser1', '2010-08-20 04:11:58.892', NULL, NULL, 'The sequence of numbers that when dialed, connects to a particular residential telephone.', 'Home', 'Home', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100047, 'superuser1', '2010-08-20 04:13:41.137', NULL, NULL, 'Phone number at place of occupation.', 'Work', 'Work', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100048, 'superuser1', '2010-08-20 04:15:26.029', NULL, NULL, 'The sequence of numbers that when dialed, connects to a particular cellular telephone.', 'Cellular', 'Cellular', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100049, 'superuser1', '2010-08-20 04:19:02.622', NULL, NULL, 'Small wireless radio receiver designed to be carried by a person and to display a short messages', 'Pager', 'Pager', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100050, 'superuser1', '2010-08-20 04:21:08.71', NULL, NULL, 'Mobile communications system.', 'Mobile Phone', 'Mobile Telephone', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100051, 'superuser1', '2010-08-20 04:22:44.38', NULL, NULL, 'An electronic device for converting between serial data from a computer and an audio signal.', 'Modem', 'Modem', 'TELEPHONENUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100052, 'superuser1', '2010-08-20 04:26:28.55', NULL, NULL, '', 'OS', 'Operating System', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100053, 'superuser1', '2010-08-20 04:27:22.193', NULL, NULL, '', 'DC', 'Data Collection', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100054, 'superuser1', '2010-08-20 04:28:07.141', NULL, NULL, '', 'IC', 'Instrument Controlling', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100055, 'superuser1', '2010-08-20 04:28:53.662', NULL, NULL, '', 'DA', 'Data Analysis', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100056, 'superuser1', '2010-08-20 04:29:47.612', NULL, NULL, '', 'WP', 'Word Processing', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100057, 'superuser1', '2010-08-20 04:30:42.561', NULL, NULL, '', 'IP', 'Image Processing', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100058, 'superuser1', '2010-08-20 04:31:14.205', NULL, NULL, '', 'Pro', 'Productivity', 'SOFTWARE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100059, 'superuser1', '2010-08-20 04:35:55.792', NULL, NULL, '', '-80Freezer', '-80C Freezer', 'STORAGEDEVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100060, 'superuser1', '2010-08-20 04:36:24.46', NULL, NULL, '', '-20Freezer', '-20C Freezer', 'STORAGEDEVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100061, 'superuser1', '2010-08-20 04:37:04.242', NULL, NULL, '', '4C Coldbox', '4C Coldbox', 'STORAGEDEVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100062, 'superuser1', '2010-08-20 04:37:44.025', NULL, NULL, '', 'LN Freezer', 'Liquid Nitrogen Freezer', 'STORAGEDEVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100063, 'superuser1', '2010-08-20 04:40:24.651', NULL, NULL, '', 'Sequencer', 'Automated Sequencer', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100064, 'superuser1', '2010-08-20 04:41:15.239', NULL, NULL, '', 'Array Scanner', 'Automated Array/Chip Scanner', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100065, 'superuser1', '2010-08-20 04:42:29.447', NULL, NULL, '', 'Sequence Detector', 'Automated Sequence Detector', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100066, 'superuser1', '2010-08-20 04:43:34.895', NULL, NULL, '', 'Spectrophotometer', 'Spectrophotometer', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100067, 'superuser1', '2010-08-20 04:44:43.417', NULL, NULL, '', 'HS Centrifuge', 'Hi-speed Centrifuge', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100068, 'superuser1', '2010-08-20 04:45:37.067', NULL, NULL, '', 'Ultra-centrifuge', 'Ultra-centrifuge', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100069, 'superuser1', '2010-08-20 04:46:41.637', NULL, NULL, '', 'Vacuum Device', 'Vacuum Device', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100070, 'superuser1', '2010-08-20 04:47:34.37', NULL, NULL, '', 'TC', 'Thermacycler', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100071, 'superuser1', '2010-08-20 04:49:42.197', NULL, NULL, '', 'Hyb Oven', 'Hybridization Oven', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100072, 'superuser1', '2010-08-20 04:50:53.433', NULL, NULL, '', 'Fluidics Station', 'Fluidics Station', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100073, 'superuser1', '2010-08-20 04:53:55.82', NULL, NULL, '', 'Table Centrifuge', 'Tabletop Centrifuge', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100074, 'superuser1', '2010-08-20 04:56:11.375', NULL, NULL, '', 'Bldg', 'Building', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100075, 'superuser1', '2010-08-20 04:56:35.66', NULL, NULL, '', 'Rm.', 'Room', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100076, 'superuser1', '2010-08-20 04:56:58.271', NULL, NULL, '', 'Shelf', 'Shelf', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100077, 'superuser1', '2010-08-20 04:57:25.669', NULL, NULL, '', 'Compartment', 'Compartment', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100078, 'superuser1', '2010-08-20 04:59:04.862', NULL, NULL, '', 'Floor', 'Floor', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100079, 'superuser1', '2010-08-20 04:59:49.516', NULL, NULL, '', 'Bay', 'Bay', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100080, 'superuser1', '2010-08-20 05:02:59.136', NULL, NULL, '', 'T', 'Temperature', 'ENVIRONMENTLCONDITION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100081, 'superuser1', '2010-08-20 05:03:22.144', NULL, NULL, '', 'Humidity', 'Humidity', 'ENVIRONMENTLCONDITION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100082, 'superuser1', '2010-08-20 05:04:10.849', NULL, NULL, '', 'Photosensitivity', 'Photosensitivity', 'ENVIRONMENTLCONDITION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100083, 'superuser1', '2010-08-20 05:04:44.458', NULL, NULL, '', 'O2', 'Oxygen Concentration', 'ENVIRONMENTLCONDITION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100084, 'superuser1', '2010-08-20 05:05:10.945', NULL, NULL, '', 'CO2', 'Carbon Dioxide Concentration', 'ENVIRONMENTLCONDITION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100085, 'superuser1', '2010-08-20 05:08:27.107', NULL, NULL, '', 'User', 'User', 'ACCOUNT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100086, 'superuser1', '2010-08-20 05:09:09.423', NULL, NULL, '', 'Vendor', 'Vendor', 'ACCOUNT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100087, 'superuser1', '2010-08-20 05:09:30.779', NULL, NULL, '', 'Customer', 'Customer', 'ACCOUNT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100088, 'superuser1', '2010-08-20 05:09:59.507', NULL, NULL, '', 'Login', 'Login', 'ACCOUNT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100089, 'superuser1', '2010-08-20 05:11:18.449', NULL, NULL, '', 'NIH CAN', 'NIH Central Accounting Number', 'ACCOUNTNUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100090, 'superuser1', '2010-08-20 05:11:52.796', NULL, NULL, '', 'NIH CCN', 'NIH Cost Center Number', 'ACCOUNTNUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100091, 'superuser1', '2010-08-20 05:12:52.77', NULL, NULL, '', 'Credit Card', 'Credit Card', 'ACCOUNTNUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100092, 'superuser1', '2010-08-20 05:13:52.212', NULL, NULL, '', 'Internal', 'Internal', 'ACCOUNTNUMBER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100093, 'superuser1', '2010-08-20 05:15:19.156', NULL, NULL, '', 'Internal', 'Internal', 'CUSTOMERREQUEST', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100094, 'superuser1', '2010-08-20 05:15:38.975', NULL, NULL, '', 'External', 'External', 'CUSTOMERREQUEST', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100095, 'superuser1', '2010-08-20 05:18:03.717', NULL, NULL, '', 'Partial', 'Partial', 'INVOICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100096, 'superuser1', '2010-08-20 05:18:20.973', NULL, NULL, '', 'Final', 'Final', 'INVOICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100097, 'superuser1', '2010-08-20 05:18:38.956', NULL, NULL, '', 'Monthly', 'Monthly', 'INVOICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100043, 'superuser1', '2010-08-20 04:06:33.895', '2010-08-23 16:35:09.023', 'labmanager1', 'for UPS/FedEx deliveries', 'Local Mail', 'Local Mail Delivery', 'POSTALADDRESS', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100100, 'superuser1', '2010-08-20 05:21:47.529', '2010-10-27 18:51:17.991', 'superuser1', 'Service Type for Quality Control.', 'Quality control', 'Quality control', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100101, 'superuser1', '2010-08-20 05:22:18.118', '2010-10-27 18:50:37.516', 'superuser1', 'Service type for Sample Quantification.', 'Quantification', 'Quantification', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100111, 'superuser1', '2010-08-20 05:34:14.104', NULL, NULL, '', 'MTA', 'Material Transfer Agreement', 'CONTRACT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100112, 'superuser1', '2010-08-20 05:34:38.591', NULL, NULL, '', 'CDA', 'Confidential Disclosure Agreement', 'CONTRACT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100113, 'superuser1', '2010-08-20 05:35:20.777', NULL, NULL, '', 'CRADA', 'Confidential Research and Development Agreement', 'CONTRACT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100114, 'superuser1', '2010-08-20 05:36:10.411', NULL, NULL, '', 'Maintenance/Service', 'Maintenance and Service', 'CONTRACT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100115, 'superuser1', '2010-08-20 05:36:39.355', NULL, NULL, '', 'Vendor', 'Vendor', 'CONTRACT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100116, 'superuser1', '2010-08-20 05:39:43.647', NULL, NULL, '', 'Specimen', 'Specimen', 'NAMINGCONVENTION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100117, 'superuser1', '2010-08-20 05:40:05.925', NULL, NULL, '', 'Equipment', 'Equipment', 'NAMINGCONVENTION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100118, 'superuser1', '2010-08-20 05:45:03.242', NULL, NULL, '', 'Country', 'Country', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100119, 'superuser1', '2010-08-20 05:45:31.936', NULL, NULL, '', 'Cty', 'County', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100120, 'superuser1', '2010-08-20 05:45:55.647', NULL, NULL, '', 'Province', 'Province', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100121, 'superuser1', '2010-08-20 05:46:21.194', NULL, NULL, '', 'Region', 'Region', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100122, 'superuser1', '2010-08-20 05:46:45.536', NULL, NULL, '', 'Territory', 'Territory', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100123, 'superuser1', '2010-08-20 05:47:12.628', NULL, NULL, '', 'PO Box', 'Post Office Box', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100124, 'superuser1', '2010-08-20 05:47:37.957', NULL, NULL, '', 'City', 'City', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100125, 'superuser1', '2010-08-20 05:48:03.54', NULL, NULL, '', 'St.', 'Street', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100126, 'superuser1', '2010-08-20 05:48:41.316', NULL, NULL, '', 'Bldg.', 'Building', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100127, 'superuser1', '2010-08-20 05:49:02.869', NULL, NULL, '', 'Rm.', 'Room', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100128, 'superuser1', '2010-08-20 05:49:30.968', NULL, NULL, '', 'GPS', 'GPS Coordinates', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100129, 'superuser1', '2010-08-20 05:50:07.911', NULL, NULL, '', 'Map Coordinates', 'Cartographic Coordinates', 'LOCATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100136, 'adminuser', '2010-08-21 11:05:54.382', NULL, NULL, '', 'Test', 'Test', 'COLLABORATION', 'ALTERNATE');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100156, 'superuser1', '2010-08-23 15:16:52.812', NULL, NULL, 'Organization in the US Federal Government.', 'Federal Govt.', 'Federal Government', 'ORGANIZATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100157, 'superuser1', '2010-08-23 15:19:24.405', NULL, NULL, 'An established society, corporation, foundation or other organization founded and united for purpose', 'Institution', 'Institution', 'ORGANIZATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100158, 'superuser1', '2010-08-23 15:21:13.797', NULL, NULL, 'A large and diverse institution of higher learning created to educate.', 'University', 'University', 'ORGANIZATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100159, 'superuser1', '2010-08-23 15:23:59.002', NULL, NULL, 'Organization who manufactures, prepares, propagates, compounds, assembles, or processes a device.', 'Manufacturer', 'Manufacturer', 'ORGANIZATION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100044, 'superuser1', '2010-08-20 04:07:40.64', '2010-08-23 16:36:43.236', 'labmanager1', 'The official mailing address; there may be a local mailing address for deliveries.', 'Official Mail', 'Official Mail', 'POSTALADDRESS', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100210, 'superuser1', '2010-08-24 14:10:41.79', NULL, NULL, 'A type of Storage Space that has 4 parts; each part is a quadrant.', 'Quadrant', 'Quadrant', 'STORAGESPACE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100214, 'superuser1', '2010-08-24 15:26:55.5', NULL, NULL, 'Automated workstation for managing fluidics.', 'AFFW', 'Automated Fluidics Workstation', 'EQUIPMENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100219, 'superuser1', '2010-08-24 15:50:05.656', NULL, NULL, 'Naming convention applied to a plate record for data collection software.', 'Plate Record', 'Plate Record', 'NAMINGCONVENTION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (1003, NULL, NULL, NULL, NULL, 'Avaliable Quantity', 'Avaliable Quantity', 'Avaliable Quantity ', 'SPECIMEN_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (1002, NULL, NULL, NULL, NULL, 'Minimum Reserve Quantity', 'Minimum Reserve Quantity', 'Minimum Reserve Quantity ', 'SPECIMEN_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (1001, NULL, NULL, NULL, NULL, 'Current Quantity', 'Current Quantity', 'Current Quantity ', 'SPECIMEN_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (1004, NULL, NULL, NULL, NULL, 'Starting Quantity', 'Starting Quantity', 'Starting Quantity ', 'SPECIMEN_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100500, 'superuser1', '2010-10-06 21:49:48.737', NULL, NULL, 'Additional name related to phenotype.', 'phenotypic', 'phenotypic', 'ADDITIONLORGANISMNAME', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100501, 'superuser1', '2010-10-06 21:50:53.25', NULL, NULL, '', 'synonym', 'synonym', 'ADDITIONLORGANISMNAME', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100502, 'superuser1', '2010-10-06 21:52:00.369', NULL, NULL, 'Common mispelling of organism name.', 'mispelling', 'misspelling', 'ADDITIONLORGANISMNAME', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100503, 'superuser1', '2010-10-06 21:56:47.471', NULL, NULL, '', 'monoclonal', 'monoclonal', 'ANTIBODY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100504, 'superuser1', '2010-10-06 21:57:29.882', NULL, NULL, '', 'polyclonal', 'polyclonal', 'ANTIBODY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100505, 'superuser1', '2010-10-06 22:13:52.769', NULL, NULL, '', 'tumor', 'tumor', 'ANTIGEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100506, 'superuser1', '2010-10-06 22:14:32.796', NULL, NULL, '', 'surface', 'surface', 'ANTIGEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100507, 'superuser1', '2010-10-06 22:14:59.772', NULL, NULL, '', 'vaccine', 'vaccine', 'ANTIGEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100508, 'superuser1', '2010-10-06 22:21:38.755', NULL, NULL, '', 'aldehyde', 'aldehyde', 'CARBOHYDRATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100509, 'superuser1', '2010-10-06 22:22:12.628', NULL, NULL, '', 'ketone', 'ketone', 'CARBOHYDRATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100510, 'superuser1', '2010-10-06 22:22:48.348', NULL, NULL, '', 'monosaccharide', 'monosaccharide', 'CARBOHYDRATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100511, 'superuser1', '2010-10-06 22:23:18.716', NULL, NULL, '', 'disaccharide', 'disaccharide', 'CARBOHYDRATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100512, 'superuser1', '2010-10-06 22:23:49.894', NULL, NULL, '', 'polysaccharide', 'polysaccharide', 'CARBOHYDRATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100513, 'superuser1', '2010-10-06 22:25:15', NULL, NULL, '', 'primary', 'primary', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100514, 'superuser1', '2010-10-06 22:25:47.668', NULL, NULL, '', 'cell line', 'cell line', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100515, 'superuser1', '2010-10-06 22:26:28.961', NULL, NULL, '', 'clone', 'clone', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100516, 'superuser1', '2010-10-06 22:27:01.079', NULL, NULL, '', 'colony', 'colony', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100517, 'superuser1', '2010-10-06 22:27:52.302', NULL, NULL, '', 'cryopreservedCell', 'cryopreservedCell', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100518, 'superuser1', '2010-10-06 22:28:38.855', NULL, NULL, '', 'viral', 'viral', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100519, 'superuser1', '2010-10-06 22:29:13.499', NULL, NULL, '', 'bacterial', 'bacterial', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100520, 'superuser1', '2010-10-06 22:30:20.226', NULL, NULL, '', 'immortalized colonic epithelial cell line', 'immortalized colonic epithelial cell line', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100521, 'superuser1', '2010-10-06 22:31:11.39', NULL, NULL, '', 'immortalized proximal intestinal myofibroblasts', 'immortalized proximal intestinal myofibroblasts', 'CELLSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100107, 'superuser1', '2010-08-20 05:30:18.214', '2010-10-27 18:19:47.584', 'superuser1', 'A rate for internal members of a group.', 'Internal', 'Internal', 'RATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100110, 'superuser1', '2010-08-20 05:31:54.132', '2010-10-27 18:20:43.699', 'superuser1', 'A discounted rate.', 'Discount', 'Discount', 'RATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100104, 'superuser1', '2010-08-20 05:24:23.194', '2010-10-27 18:52:13.031', 'superuser1', 'Service Type for Consultation Service.', 'Consultation', 'Consultation', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100106, 'superuser1', '2010-08-20 05:27:39.11', '2010-10-27 18:52:43.858', 'superuser1', 'Service Type for Array-based SNP Genotype.', 'Array-based SNP GT', 'Array-based SNP Genotype', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100105, 'superuser1', '2010-08-20 05:26:36.842', '2010-10-27 18:53:47.882', 'superuser1', 'Service Type for Array-based Copy Number Variation.', 'Array-based CNV', 'Array-based Copy Number Variation', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100522, 'superuser1', '2010-10-06 22:36:30.389', NULL, NULL, '', 'RE site', 'Restriction Enzyme site', 'FEATURE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100523, 'superuser1', '2010-10-06 22:37:15.768', NULL, NULL, '', 'AbBindingSite', 'Antibody Binding Site', 'FEATURE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100524, 'superuser1', '2010-10-06 22:39:03.193', NULL, NULL, '', 'c-terminus', 'Carboxy-Terminus', 'FEATURE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100525, 'superuser1', '2010-10-06 22:42:28.879', NULL, NULL, 'The N-terminus (also known as the amino-terminus, NH2-terminus, N-terminal end or amine-terminus).', 'n-terminus', 'Amino-Terminus', 'FEATURE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100526, 'superuser1', '2010-10-06 22:47:31.95', NULL, NULL, '', 'word processing', 'word processing', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100527, 'superuser1', '2010-10-06 22:47:52.263', NULL, NULL, '', 'spreadsheet', 'spreadsheet', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100528, 'superuser1', '2010-10-06 22:48:11.749', NULL, NULL, '', 'database', 'database', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100529, 'superuser1', '2010-10-06 22:48:33.354', NULL, NULL, '', 'data', 'data', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100530, 'superuser1', '2010-10-06 22:49:27.995', NULL, NULL, '', 'imaging/graphics', 'imaging/graphics', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100531, 'superuser1', '2010-10-06 22:49:55.379', NULL, NULL, '', 'data compression/archive', 'data compression/archive', 'FILEEXTENSION', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100532, 'superuser1', '2010-10-06 22:51:15.95', NULL, NULL, '', 'blood', 'blood', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100533, 'superuser1', '2010-10-06 22:51:40.534', NULL, NULL, '', 'plasma', 'plasma', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100534, 'superuser1', '2010-10-06 22:51:55.576', NULL, NULL, '', 'serum', 'serum', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100535, 'superuser1', '2010-10-06 22:52:31.088', NULL, NULL, '', 'urine', 'urine', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100536, 'superuser1', '2010-10-06 22:53:04.474', NULL, NULL, '', 'saliva', 'saliva', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100537, 'superuser1', '2010-10-06 22:53:41.449', NULL, NULL, '', 'exudate', 'exudate', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100538, 'superuser1', '2010-10-06 22:54:22.18', NULL, NULL, '', 'gastric fluid', 'gastric fluid', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100539, 'superuser1', '2010-10-06 22:55:06.884', NULL, NULL, '', 'broncheolar lavage fluid', 'broncheolar lavage fluid', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100540, 'superuser1', '2010-10-06 22:55:38.863', NULL, NULL, '', 'lysate', 'lysate', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100541, 'superuser1', '2010-10-06 22:56:15.474', NULL, NULL, '', 'extract', 'extract', 'FLUIDSPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100542, 'superuser1', '2010-10-06 22:59:49.544', NULL, NULL, '', 'radioactive', 'radioactive', 'HAZARD', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100543, 'superuser1', '2010-10-06 23:00:21.351', NULL, NULL, '', 'infectious', 'infectious', 'HAZARD', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100544, 'superuser1', '2010-10-06 23:00:58.594', NULL, NULL, '', 'toxic', 'toxic', 'HAZARD', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100545, 'superuser1', '2010-10-06 23:01:26.246', NULL, NULL, '', 'carcinogenic', 'carcinogenic', 'HAZARD', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100546, 'superuser1', '2010-10-06 23:01:47.873', NULL, NULL, '', 'mutagenic', 'mutagenic', 'HAZARD', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100547, 'superuser1', '2010-10-06 23:03:39.701', NULL, NULL, '', 'PPD', 'personal protective device', 'LABSUPPLY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100548, 'superuser1', '2010-10-06 23:04:11.998', NULL, NULL, '', 'sealer', 'sealer', 'LABSUPPLY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100549, 'superuser1', '2010-10-06 23:04:32.794', NULL, NULL, '', 'plate', 'plate', 'LABSUPPLY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100550, 'superuser1', '2010-10-06 23:05:07.835', NULL, NULL, '', 'microarray', 'microarray', 'LABSUPPLY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100551, 'superuser1', '2010-10-06 23:06:44.365', NULL, NULL, '', 'glyceride', 'glyceride', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100552, 'superuser1', '2010-10-06 23:07:15.841', NULL, NULL, '', 'liposome', 'liposome', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100553, 'superuser1', '2010-10-06 23:07:45.849', NULL, NULL, '', 'nanosome', 'nanosome', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100554, 'superuser1', '2010-10-06 23:08:07.246', NULL, NULL, '', 'bilayer', 'bilayer', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100555, 'superuser1', '2010-10-06 23:10:24.762', NULL, NULL, '', 'nanoparticle', 'nanoparticle', 'NANOMATERIAL', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100556, 'superuser1', '2010-10-06 23:11:59.048', NULL, NULL, '', 'oligo', 'oligonucleotide', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100557, 'superuser1', '2010-10-06 23:12:22.765', NULL, NULL, '', 'plasmid', 'plasmid', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100558, 'superuser1', '2010-10-06 23:12:52.069', NULL, NULL, '', 'cosmid', 'cosmid', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100559, 'superuser1', '2010-10-06 23:13:22.786', NULL, NULL, '', 'transgene', 'transgene', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100560, 'superuser1', '2010-10-06 23:14:28.217', NULL, NULL, '', 'BAC', 'bacterial artificial chromosome (BAC)', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100561, 'superuser1', '2010-10-06 23:14:58.064', NULL, NULL, '', 'YAC', 'yeast artificial chromosome (YAC)', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100562, 'superuser1', '2010-10-06 23:15:41.195', NULL, NULL, '', 'chromosome', 'chromosome', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100563, 'superuser1', '2010-10-06 23:16:11.46', NULL, NULL, '', 'genome', 'genome', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100564, 'superuser1', '2010-10-06 23:16:47.802', NULL, NULL, '', 'mRNA', 'messenger RNA', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100565, 'superuser1', '2010-10-06 23:17:17.649', NULL, NULL, '', 'tRNA', 'transfer RNA', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100566, 'superuser1', '2010-10-06 23:17:49.166', NULL, NULL, '', 'miRNA', 'micro RNA', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100567, 'superuser1', '2010-10-06 23:18:13.113', NULL, NULL, '', 'DNA', 'DNA', 'NUCLEICACID', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100568, 'superuser1', '2010-10-06 23:18:40.785', NULL, NULL, '', 'siRNA', 'siRNA', 'NUCLEICACID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100569, 'superuser1', '2010-10-06 23:20:02.265', NULL, NULL, '', 'primary', 'primary', 'PCRPRODUCT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100570, 'superuser1', '2010-10-06 23:20:21.283', NULL, NULL, '', 'nested', 'nested', 'PCRPRODUCT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100571, 'superuser1', '2010-10-06 23:21:56.74', NULL, NULL, '', 'instrument', 'instrument', 'PARAMETER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100572, 'superuser1', '2010-10-06 23:22:21.462', NULL, NULL, '', 'software', 'software', 'PARAMETER', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100573, 'superuser1', '2010-10-06 23:51:01.529', NULL, NULL, '', 'amplification', 'amplification', 'PRIMER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100574, 'superuser1', '2010-10-06 23:51:29.088', NULL, NULL, '', 'sequencing', 'sequencing', 'PRIMER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100575, 'superuser1', '2010-10-06 23:52:00.603', NULL, NULL, '', 'interrogating', 'interrogating', 'PRIMER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100576, 'superuser1', '2010-10-06 23:53:04.244', NULL, NULL, '', 'structural', 'structural', 'PROTEIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100577, 'superuser1', '2010-10-06 23:53:30.294', NULL, NULL, '', 'enzyme', 'enzyme', 'PROTEIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100578, 'superuser1', '2010-10-06 23:53:58.441', NULL, NULL, '', 'cell signaling', 'cell signaling', 'PROTEIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100579, 'superuser1', '2010-10-06 23:54:41.276', NULL, NULL, '', 'transport', 'transport', 'PROTEIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100580, 'superuser1', '2010-10-06 23:56:23.299', NULL, NULL, '', 'drug', 'drug', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100581, 'superuser1', '2010-10-06 23:56:50.8', NULL, NULL, '', 'prodrug', 'prodrug', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100582, 'superuser1', '2010-10-06 23:57:16.761', NULL, NULL, '', 'antiviral', 'antiviral', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100583, 'superuser1', '2010-10-06 23:57:50.488', NULL, NULL, '', 'anticarcinogenic', 'anticarcinogenic', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100584, 'superuser1', '2010-10-06 23:58:16.333', NULL, NULL, '', 'cell signalling', 'cell signalling', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100585, 'superuser1', '2010-10-06 23:58:40.173', NULL, NULL, '', 'antioxidant', 'antioxidant', 'SMALLMOLECULE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100586, 'superuser1', '2010-10-07 00:01:09.161', NULL, NULL, '', 'tumor', 'tumor', 'TISSUESPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100587, 'superuser1', '2010-10-07 00:01:36.541', NULL, NULL, '', 'non-tumor', 'non-tumor', 'TISSUESPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100588, 'superuser1', '2010-10-07 00:02:01.47', NULL, NULL, '', 'normal', 'normal', 'TISSUESPECIMEN', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100589, 'superuser1', '2010-10-07 00:02:34.336', NULL, NULL, '', 'tumor-adjacent', 'tumor-adjacent', 'TISSUESPECIMEN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100590, 'superuser1', '2010-10-07 00:04:08.151', NULL, NULL, '', 'mass', 'mass', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100591, 'superuser1', '2010-10-07 00:04:46.241', NULL, NULL, '', 'distance', 'distance', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100592, 'superuser1', '2010-10-07 00:05:14.046', NULL, NULL, '', 'time', 'time', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100593, 'superuser1', '2010-10-07 00:05:30.462', NULL, NULL, '', 'temperature', 'temperature', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100594, 'superuser1', '2010-10-07 00:06:20.684', NULL, NULL, '', 'atomic weight', 'atomic weight', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100595, 'superuser1', '2010-10-07 00:06:53.305', NULL, NULL, '', 'concentration', 'concentration', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100596, 'superuser1', '2010-10-07 00:07:12.15', NULL, NULL, '', 'volume', 'volume', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100597, 'superuser1', '2010-10-07 00:07:47.082', NULL, NULL, '', 'pressure', 'pressure', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100598, 'superuser1', '2010-10-07 00:08:13.786', NULL, NULL, '', 'centrifugal force', 'centrifugal force', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100599, 'superuser1', '2010-10-07 00:10:24.865', NULL, NULL, '', 'animal', 'animal', 'WHOLEORGANISM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100600, 'superuser1', '2010-10-07 00:10:51.954', NULL, NULL, '', 'nematode', 'nematode', 'WHOLEORGANISM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100601, 'superuser1', '2010-10-07 00:11:08.622', NULL, NULL, '', 'fish', 'fish', 'WHOLEORGANISM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100602, 'superuser1', '2010-10-07 00:11:36.009', NULL, NULL, '', 'insect', 'insect', 'WHOLEORGANISM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100603, 'superuser1', '2010-10-07 00:13:30.746', NULL, NULL, '', 'physical', 'physical', 'CHARACTERISTICS', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100604, 'superuser1', '2010-10-07 00:13:55.455', NULL, NULL, '', 'chemical', 'chemical', 'CHARACTERISTICS', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100605, 'superuser1', '2010-10-07 00:14:23.535', NULL, NULL, '', 'biological', 'biological', 'CHARACTERISTICS', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100606, 'superuser1', '2010-10-07 00:21:00.878', NULL, NULL, '', 'collection', 'collection', 'EVENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100607, 'superuser1', '2010-10-07 00:21:19.881', NULL, NULL, '', 'transfer', 'transfer', 'EVENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100608, 'superuser1', '2010-10-07 00:21:38.822', NULL, NULL, '', 'mating', 'mating', 'EVENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100609, 'superuser1', '2010-10-07 00:22:00.337', NULL, NULL, '', 'processing', 'processing', 'EVENT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100610, 'superuser1', '2010-10-07 00:23:53.741', NULL, NULL, '', 'inbred', 'inbred', 'STRAIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100611, 'superuser1', '2010-10-07 00:24:24.806', NULL, NULL, '', 'development', 'development', 'STRAIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100612, 'superuser1', '2010-10-07 00:25:53.371', NULL, NULL, '', 'transgenic', 'transgenic', 'STRAIN', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100632, 'superuser1', '2010-10-07 16:17:39.813', NULL, NULL, 'A single fatty acid chain bound to gycerol', 'monoglyceride', 'monoglyceride', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100638, 'superuser1', '2010-10-07 16:45:08.362', NULL, NULL, 'carboxylic acid with a long unbranched aliphatic tail', 'fatty acid', 'fatty acid', 'LIPID', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (3, NULL, NULL, NULL, NULL, 'Minimum Capacity', 'Minimum Capacity', 'Minimum Capacity', 'CONTAINER_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (1, NULL, NULL, NULL, NULL, 'Maximum Capacity', 'Maximum Capacity', 'Maximum Capacity', 'CONTAINER_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (2, NULL, NULL, NULL, NULL, 'Current Quantity', 'Current Quantity', 'Current Quantity', 'CONTAINER_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9002, NULL, NULL, NULL, NULL, 'Minimum Archived Quantity', 'Minimum Archived Quantity', 'Minimum Archived Quantity ', 'LABSUPPLY_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9001, NULL, NULL, NULL, NULL, 'Initial Quantity', 'Initial Quantity', 'Initial Quantity', 'LABSUPPLY_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9003, NULL, NULL, NULL, NULL, 'Available Quantity', 'Available Quantity', 'Available Quantity ', 'LABSUPPLY_QUANTITY', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9004, NULL, NULL, NULL, NULL, 'Box', 'Box', 'Box ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9005, NULL, NULL, NULL, NULL, 'Bottle', 'Bottle', 'Bottle ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9006, NULL, NULL, NULL, NULL, 'Cannister', 'Cannister', 'Cannister ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9060, NULL, NULL, NULL, NULL, 'Cassette', 'Cassette', 'Cassette', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9007, NULL, NULL, NULL, NULL, 'Flask', 'Flask', 'Flask ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9008, NULL, NULL, NULL, NULL, 'Kit', 'Kit', 'Kit ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9009, NULL, NULL, NULL, NULL, 'Pen', 'Pen', 'Pen ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9010, NULL, NULL, NULL, NULL, 'Plate', 'Plate', 'Plate ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9011, NULL, NULL, NULL, NULL, 'Rack', 'Rack', 'Rack ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9012, NULL, NULL, NULL, NULL, 'Shipping', 'Shipping', 'Shipping ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9013, NULL, NULL, NULL, NULL, 'Straw', 'Straw', 'Straw ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9014, NULL, NULL, NULL, NULL, 'Swab', 'Swab', 'Swab ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (9015, NULL, NULL, NULL, NULL, 'Tube', 'Tube', 'Tube ', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199535, 'superuser1', '2010-10-27 18:18:16.45', NULL, NULL, 'A rate based on negotiations for a project or collaboration.', 'Negotiated', 'Negotiated', 'RATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100109, 'superuser1', '2010-08-20 05:31:19.171', '2010-10-27 18:19:13.84', 'superuser1', 'A rate based on high volumes or multi-discounts.', 'Multi-Discount', 'Multi-Discount', 'RATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100108, 'superuser1', '2010-08-20 05:30:35.961', '2010-10-27 18:20:28.632', 'superuser1', 'A rate for external users or groups.', 'External', 'External', 'RATE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199509, 'superuser1', '2010-10-22 14:18:26.048', NULL, NULL, 'A single ''well'' in a container that cannot be physically separated from the parent container (example a well in a 96-well plate).', 'Well', 'Well', 'CONTAINER', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199520, 'superuser1', '2010-10-22 16:23:08.755', NULL, NULL, 'testVolumeType1testVolumeType1testVolumeType1testVolumeType1testVolumeType1testVolumeType1testVolumeType1testVolumeType1', 'testVolumeType1', 'testVolumeType1', 'UNIT', 'ALTERNATE');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199522, 'superuser1', '2010-10-22 17:22:13.95', NULL, NULL, 'unit for a single entity', 'each', 'each', 'UNIT', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199525, 'superuser1', '2010-10-22 17:26:00.537', NULL, NULL, 'Storage device for materials sensitive to humidity and moisture.', 'Dessicator', 'Dessicator', 'STORAGEDEVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199539, 'superuser1', '2010-10-27 18:26:30.438', NULL, NULL, 'Consultation Service Default Service Item.', 'Consultation Service', 'Consultation Service', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199538, 'superuser1', '2010-10-27 18:25:03.886', '2010-10-27 18:27:04.813', 'superuser1', 'Array-based Single Nucleotide Polymorphism Genotyping Default Service Item.', 'Array-based SNP Genotyping', 'Array-based Single Nucleotide Polymorphism Genotyping', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199537, 'superuser1', '2010-10-27 18:23:34.34', '2010-10-27 18:27:18.366', 'superuser1', 'Array-based Gene Expression Default Service Item.', 'Array-based Gene Expression', 'Array-based Gene Expression', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199536, 'superuser1', '2010-10-27 18:22:47.461', '2010-10-27 18:27:31.188', 'superuser1', 'Array-based Copy Number Variation Default Service Item.', 'Array-based CNV', 'Array-based Copy Number Variation', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199540, 'superuser1', '2010-10-27 18:28:32.654', NULL, NULL, 'Assay Method Design Service Default Service Item.', 'Assay Method Design Service', 'Assay Method Design Service', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199541, 'superuser1', '2010-10-27 18:29:25.501', NULL, NULL, 'Quality Control Default Service Item.', 'Quality Control', 'Quality Control', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199542, 'superuser1', '2010-10-27 18:30:15.963', NULL, NULL, 'Quantitation Default Service Item.', 'Quantitation', 'Quantitation', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199543, 'superuser1', '2010-10-27 18:30:57.465', NULL, NULL, 'Sample Preparation Default Service Item.', 'Sample Preparation', 'Sample Preparation', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199545, 'superuser1', '2010-10-27 18:33:02.733', NULL, NULL, 'Sanger Sequencing Default Service Item.', 'Sequencing - Sanger', 'Sequencing - Sanger', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199544, 'superuser1', '2010-10-27 18:32:03.013', '2010-10-27 18:36:14.922', 'superuser1', 'NexGen Sequencing (SoLID platform) Default Service Item.', 'Sequencing - NexGen - SoLID', 'Sequencing - NexGen - SoLID', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199546, 'superuser1', '2010-10-27 18:38:52.838', NULL, NULL, 'NexGen Sequencing (Illumina HiSeq platform) Default Service Item.', 'Sequencing - NexGen - HiSeq', 'Sequencing - NexGen - HiSeq', 'SERVICEITEM', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100098, 'superuser1', '2010-08-20 05:20:35.614', '2010-10-27 18:44:01.353', 'superuser1', 'Service type for Sanger sequencing using automated capillary sequencers.', 'Sequencing - Sanger', 'Sequencing - Sanger', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199547, 'superuser1', '2010-10-27 18:42:30.625', '2010-10-27 18:44:15.635', 'superuser1', 'Service type for NexGen Sequencing- SoLID platform.', 'Sequencing - NexGen - SoLID', 'Sequencing - NexGen - SoLID', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199548, 'superuser1', '2010-10-27 18:43:19.771', '2010-10-27 18:44:34.24', 'superuser1', 'Service type for NexGen Sequencing- HiSeq platform.', 'Sequencing - NexGen - HiSeq', 'Sequencing - NexGen - HiSeq', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100102, 'superuser1', '2010-08-20 05:22:51.526', '2010-10-27 18:45:05.821', 'superuser1', 'Service type for Sample preparation.', 'Sample preparation', 'Sample preparation', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100103, 'superuser1', '2010-08-20 05:23:52.53', '2010-10-27 18:51:47.326', 'superuser1', 'Service Type for Method or assay design.', 'Method design', 'Method design', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (100099, 'superuser1', '2010-08-20 05:21:08.516', '2010-10-27 18:53:13.944', 'superuser1', 'Service Type for Array-based Gene Expression.', 'Array-based GE', 'Array-based Gene Expression', 'SERVICE', 'CURRENT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199549, 'superuser1', '2010-10-27 19:01:24.833', NULL, NULL, 'The Default Billing Information Type for the system.', 'Default Billing Information Type', 'Default Billing Information Type', 'BILLINGINFORMATION', 'DEFAULT');
INSERT INTO type (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dataelementcollection, status) VALUES (199550, 'superuser1', '2010-10-27 19:02:02.852', NULL, NULL, 'A Custom Billing Information Type.', 'Custom Billing Information Type', 'Custom Billing Information Type', 'BILLINGINFORMATION', 'ALTERNATE');


--
-- TOC entry 2931 (class 0 OID 3741861)
-- Dependencies: 1889 3057
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO account (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, laboratory_fk, organization_fk, type_fk) VALUES (100132, 'superuser1', '2010-08-20 19:52:36.835', NULL, NULL, 'Demo Account 1.', 'Account1', 'Account1', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\0012\\035"\\234\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\001*\\214\\313|\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', 'ACTIVE', 100131, 100001, 100087);
INSERT INTO account (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, laboratory_fk, organization_fk, type_fk) VALUES (100201, 'superuser1', '2010-08-23 23:22:57.286', NULL, NULL, 'Account for University 1 available for Orders for Test Lab1 Core Facility.', 'Univ1Acct1', 'University1 Account1', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\0011}}x\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\001*0\\031\\004\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', 'ACTIVE', 100183, 100163, 100087);
INSERT INTO account (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, laboratory_fk, organization_fk, type_fk) VALUES (100204, 'superuser1', '2010-08-23 23:44:53.7', NULL, NULL, 'Account for Demo Univ2 for Customer Service by Test Org1.', 'Demo Univ2 Acct1', 'Demo University 2 Account 1', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\0012\\267\\241d\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\001*0\\031\\004\\000sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\011\\000\\007Etc/UTCxx', 'ACTIVE', 100178, 100165, 100087);


--
-- TOC entry 2932 (class 0 OID 3741869)
-- Dependencies: 1890 3057 2931
-- Data for Name: accountnumber; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO accountnumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, value, account_fk, type_fk) VALUES (100133, 'superuser1', '2010-08-20 19:55:10.774', NULL, NULL, 'Credit Card Account # for Lab One', 'Lab1CC1', 'Lab OneCredit Card1', '2011-08-31 00:00:00', '2010-08-20 00:00:00', 'DEFAULT', 1111222233334444, 100132, 100091);
INSERT INTO accountnumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, value, account_fk, type_fk) VALUES (100134, 'superuser1', '2010-08-20 19:56:59.809', NULL, NULL, 'Another credit card account number for Lab One', 'Lab1CC2', 'Lab One Credit Card 2', '2011-08-01 00:00:00', '2010-08-02 00:00:00', 'DEFAULT', 2222333344445555, 100132, 100091);


--
-- TOC entry 2935 (class 0 OID 3741893)
-- Dependencies: 1893
-- Data for Name: antibody; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO antibody (countofrequests, isotype, recommendeddilutionrange, id, antigen_fk) VALUES (NULL, NULL, NULL, 100625, NULL);
INSERT INTO antibody (countofrequests, isotype, recommendeddilutionrange, id, antigen_fk) VALUES (NULL, 'IgG', '1:250 to 1:100', 100626, NULL);


--
-- TOC entry 2936 (class 0 OID 3741898)
-- Dependencies: 1894 3057
-- Data for Name: antigen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3059 (class 0 OID 3742609)
-- Dependencies: 2017 3057
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100624, 'superuser1', '2010-10-07 04:05:08.008', NULL, NULL, '1/1,000,000 of liter', 'ul', 'microliter', 100596);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100500, 'superuser1', '2010-10-21 17:21:18.512', NULL, NULL, 'basic unit for weight/mass', 'g', 'Gram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100502, 'superuser1', '2010-10-21 17:22:49.162', NULL, NULL, 'basic unit for concentration', 'mg/ml', 'milligram per milliliter', 100595);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100503, 'superuser1', '2010-10-21 17:22:49.164', NULL, NULL, 'basic unit for concentration', 'mg/ml', 'milligram per milliliter', 100595);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100504, 'superuser1', '2010-10-21 17:23:23.13', NULL, NULL, 'basic unit for distance', 'm', 'meter', 100591);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100505, 'superuser1', '2010-10-21 17:23:23.133', NULL, NULL, 'basic unit for distance', 'm', 'meter', 100591);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100506, 'superuser1', '2010-10-21 17:24:08.002', NULL, NULL, 'basic unit for pressure', 'mmHg', 'millimeters of mercury', 100597);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100507, 'superuser1', '2010-10-21 17:24:08.005', NULL, NULL, 'basic unit for pressure', 'mmHg', 'millimeters of mercury', 100597);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100508, 'superuser1', '2010-10-21 17:25:43.119', NULL, NULL, 'basic unit for temperature', 'C', 'Celsius', 100593);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100509, 'superuser1', '2010-10-21 17:25:43.122', NULL, NULL, 'basic unit for temperature', 'C', 'Celsius', 100593);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100510, 'superuser1', '2010-10-21 17:26:16.822', NULL, NULL, 'basic unit for time', 'hr', 'hour', 100592);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100511, 'superuser1', '2010-10-21 17:26:16.833', NULL, NULL, 'basic unit for time', 'hr', 'hour', 100592);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100512, 'superuser1', '2010-10-21 17:38:18.116', NULL, NULL, 'basic unit for atomic weight', 'mol', 'mole', 100594);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100513, 'superuser1', '2010-10-21 17:38:18.12', NULL, NULL, 'basic unit for atomic weight', 'mol', 'mole', 100594);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100623, 'superuser1', '2010-10-07 04:03:47.157', '2010-10-21 17:40:10.904', 'superuser1', '1/1000 of liter', 'ml', 'milliliter', 100596);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (199530, 'adminuser', '2010-10-25 12:33:09.567', NULL, NULL, 'milligram ', 'mg', 'milligram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100515, 'superuser1', '2010-10-21 17:44:22.287', NULL, NULL, 'nl = 10-9 liter', 'nl', 'nanoliter', 100596);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100516, 'superuser1', '2010-10-21 17:46:04.574', NULL, NULL, 'milligram = 0.001 gram', 'mg', 'milligram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100519, 'superuser1', '2010-10-21 18:07:03.861', '2010-10-21 18:29:15.07', 'superuser1', 'picoliter = 10-12 liter', 'pl', 'pico liter', 100596);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100501, 'superuser1', '2010-10-21 17:21:18.546', '2010-10-21 18:30:22.887', 'superuser1', 'basic unit for weight/mass', 'g', 'gram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100522, 'superuser1', '2010-10-21 18:31:45.857', NULL, NULL, 'microgram = 10-6 gram', 'ug', 'microgram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100523, 'superuser1', '2010-10-21 18:33:28.946', NULL, NULL, 'nanogram = 10-9 gram', 'ng', 'nanogram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100524, 'superuser1', '2010-10-21 18:34:16.091', NULL, NULL, 'picogram = 10-12 gram', 'pg', 'picogram', 100590);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100525, 'superuser1', '2010-10-21 18:38:09.812', NULL, NULL, 'minute is 1/60 of hour', 'min', 'minute', 100592);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100526, 'superuser1', '2010-10-21 18:39:50.529', NULL, NULL, 'day = 24 hours', 'day', 'day', 100592);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100527, 'superuser1', '2010-10-21 18:45:47.791', NULL, NULL, 'ng/ul = mg/ml', 'ng/ul', 'nanogram per microliter', 100595);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100621, 'superuser1', '2010-10-07 04:01:02.904', '2010-10-22 16:23:17.001', 'superuser1', 'This a unit for Unit type Volume .....

.....

', 'L', 'Liter', 100596);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (199523, 'superuser1', '2010-10-22 17:23:06.082', NULL, NULL, 'unit for a single entity', 'each', 'each', 199522);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (199524, 'superuser1', '2010-10-22 17:23:06.086', NULL, NULL, 'unit for a single entity', 'each', 'each', 199522);
INSERT INTO unit (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (100622, 'superuser1', '2010-10-07 04:01:02.912', '2010-10-22 17:24:36.948', 'superuser1', 'base unit for type Volume ', 'L', 'Liter', 100596);


--
-- TOC entry 2938 (class 0 OID 3741911)
-- Dependencies: 1896 3059
-- Data for Name: baseunit; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO baseunit (id) VALUES (100621);
INSERT INTO baseunit (id) VALUES (100500);
INSERT INTO baseunit (id) VALUES (100502);
INSERT INTO baseunit (id) VALUES (100504);
INSERT INTO baseunit (id) VALUES (100506);
INSERT INTO baseunit (id) VALUES (100508);
INSERT INTO baseunit (id) VALUES (100510);
INSERT INTO baseunit (id) VALUES (100512);
INSERT INTO baseunit (id) VALUES (199523);


--
-- TOC entry 3043 (class 0 OID 3742508)
-- Dependencies: 2001 3059 2938
-- Data for Name: standardunit; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100622, 100621);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (0.00, NULL, NULL, NULL, 100624, 100621);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100501, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100503, 100502);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100505, 100504);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100507, 100506);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100509, 100508);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100511, 100510);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100513, 100512);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1000.00, NULL, NULL, NULL, 100623, 100621);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (0.00, NULL, NULL, NULL, 199530, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (100000000.00, NULL, NULL, NULL, 100515, 100621);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1000.00, NULL, NULL, NULL, 100516, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1000000000000.00, NULL, NULL, NULL, 100519, 100621);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (100000.00, NULL, NULL, NULL, 100522, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (100000000.00, NULL, NULL, NULL, 100523, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (100000000000.00, NULL, NULL, NULL, 100524, 100500);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (60.00, NULL, NULL, NULL, 100525, 100510);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (0.04, NULL, NULL, NULL, 100526, 100510);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 100527, 100502);
INSERT INTO standardunit (conversionfactor, datasource, datatarget, offsetvalue, id, baseunit_fk) VALUES (1.00, NULL, NULL, NULL, 199524, 199523);


--
-- TOC entry 2939 (class 0 OID 3741916)
-- Dependencies: 1897 3057 3057 3043
-- Data for Name: billinginformation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3054 (class 0 OID 3742572)
-- Dependencies: 2012
-- Data for Name: taxon; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO taxon (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, commonname, genus, ncbitaxonomyid, populationgroup, species, speciessubgroup) VALUES (100615, 'superuser1', '2010-10-07 03:38:50.216', NULL, NULL, 'A model organism for understanding the genetic control of development  and physiology.', 'worm (C. elegans)', 'worm (Caenorhabditis elegans)', 'worm', 'Caenorhabditis', '', '', 'elegans', '');
INSERT INTO taxon (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, commonname, genus, ncbitaxonomyid, populationgroup, species, speciessubgroup) VALUES (100613, 'superuser1', '2010-10-07 03:29:30.754', '2010-10-07 03:39:16.185', 'superuser1', 'taxon for human', 'human', 'Human (Homo sapiens)', 'human', 'Homo', '', '', 'sapiens', 'sapiens');
INSERT INTO taxon (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, commonname, genus, ncbitaxonomyid, populationgroup, species, speciessubgroup) VALUES (100617, 'superuser1', '2010-10-07 03:42:11.757', NULL, NULL, 'taxon for common goat (Capra aegagrus) used to produce antibodies.', 'goat (C. aegagrus)', 'Capra aegagrus', 'goat', 'Capra', '', '', 'aegagrus', '');
INSERT INTO taxon (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, commonname, genus, ncbitaxonomyid, populationgroup, species, speciessubgroup) VALUES (100619, 'superuser1', '2010-10-07 03:44:24.729', NULL, NULL, 'taxon for a bacterial pathogen associated with bacteremia, pneumonia, and menigitis.', 'H. influenzae type b', 'Haemophilus influenzae', 'H. influenzae type b', 'Haemophilus', '', '', 'influenzae', 'type b');
INSERT INTO taxon (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, commonname, genus, ncbitaxonomyid, populationgroup, species, speciessubgroup) VALUES (100614, 'superuser1', '2010-10-07 03:34:01.877', '2010-10-07 03:57:31.333', 'superuser1', 'taxon for common mouse in North America', 'mouse (domesticus)', 'mouse (M.musculus, domesticus)', 'house mouse', 'Mus', '', '', 'musculus', 'domesticus');


--
-- TOC entry 2941 (class 0 OID 3741929)
-- Dependencies: 1899 3057 3054
-- Data for Name: biospecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100625, NULL, 100503);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100626, 100614, 100503);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100629, 100613, 100514);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100630, 100613, 100534);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100631, 100614, 100577);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100634, 100613, 100573);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100635, 100613, 100573);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100636, 100613, 100569);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100637, 100613, 100586);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100633, 100613, 100638);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100639, NULL, 100583);
INSERT INTO biospecimen (id, taxon_fk, type_fk) VALUES (100552, 100614, 100599);


--
-- TOC entry 2944 (class 0 OID 3741944)
-- Dependencies: 1902
-- Data for Name: chemicalcompound; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO chemicalcompound (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, ndccode, chemicalformula, expirationdate, container_fk, nanomaterial_fk) VALUES (199526, 'superuser1', '2010-10-22 17:32:36.032', NULL, NULL, 'Working stock of 3700XL running buffer (1X) made on 10/21/10.', 'AB_1X_RunningBuffer_21Oct10', 'AB_1X_RunningBuffer_21Oct10', '', '', '2010-11-04 00:00:00', 100542, NULL);


--
-- TOC entry 2947 (class 0 OID 3741968)
-- Dependencies: 1905
-- Data for Name: container; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100542, 'superuser1', '2010-10-21 21:15:32.687', NULL, NULL, 'Buffer Bottle1 created 10.21.10 - 500 ml.', 'Buffer Bottle1 10.21.10', 'Buffer Bottle1 10.21.10', 0, 0, true, false, 'AVAILABLE', 9068, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100543, 'superuser1', '2010-10-21 21:21:34.928', NULL, NULL, '1L Flask1 10.21.10', '1L Flask1 10.21.10', '1L Flask1 10.21.10', 0, 0, true, true, 'AVAILABLE', 9085, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100544, 'superuser1', '2010-10-21 21:23:52.715', NULL, NULL, 'Shipping Container (small) template', 'Shipping Container (small)', 'Shipping Container (small)', 0, 0, true, true, 'ACTIVE', 9128, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100545, 'superuser1', '2010-10-21 21:25:57.725', NULL, NULL, 'CBS 0.5 ml Straw Template', 'CBS 0.5 ml Straw Template', 'CBS 0.5 ml Straw Template', 0, 0, false, true, 'ACTIVE', 9133, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100546, 'superuser1', '2010-10-21 21:29:02.217', NULL, NULL, 'CBS 0.3 ml Straw template', 'CBS 0.3 ml Straw template', 'CBS 0.3 ml Straw template', 0, 0, false, true, 'ACTIVE', 9132, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100548, 'superuser1', '2010-10-21 21:34:58.813', NULL, NULL, '1.5mlMicrotube_D0001', '1.5mlMicrotube_D0001', '1.5mlMicrotube_D0001', 0, 0, false, false, 'ACTIVE', 9157, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100549, 'superuser1', '2010-10-21 21:36:12.389', NULL, NULL, '1.5mlMicrotube_D0002', '1.5mlMicrotube_D0002', '1.5mlMicrotube_D0002', 0, 0, false, false, 'ACTIVE', 9157, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100550, 'superuser1', '2010-10-21 21:37:40.429', NULL, NULL, '1.5mlMicrotube_D0003', '1.5mlMicrotube_D0003', '1.5mlMicrotube_D0003', 0, 0, false, false, 'ACTIVE', 9153, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100551, 'superuser1', '2010-10-21 21:39:23.365', NULL, NULL, 'Cage_101 is a pen for mice breeding.', 'Cage_101', 'Cage_101', 0, 0, true, false, 'AVAILABLE', 9096, NULL, 100502, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (199528, 'adminuser', '2010-10-25 11:47:13.837', NULL, NULL, '', 'proj1_96well_plt1', 'proj1_96well_plt1', 0, 0, false, false, 'ACTIVE', 9109, NULL, 100501, 100155, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (100547, 'superuser1', '2010-10-21 21:32:13.938', '2010-10-22 14:51:49.687', 'superuser1', 'Tube, 3ml polypropylene screwtop template', 'Tube, 3ml polypropylene screwtop template', 'Tube, 3ml polypropylene screwtop template', 0, 0, false, true, 'AVAILABLE', 9164, NULL, 100502, 100200, 100544);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (199519, 'superuser1', '2010-10-22 14:54:44.21', NULL, NULL, 'Demo freezer rack for boxes.', 'LabDemoRack_0001', 'LabDemoRack_0001', 0, 0, true, false, 'ACTIVE', 9119, NULL, 100506, 100200, NULL);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (199521, 'superuser1', '2010-10-22 16:47:20.599', NULL, NULL, '', 'Project_test1_box11', 'Project_test1_box11', 0, 0, false, false, 'ACTIVE', 9072, NULL, 100508, 100162, 199519);
INSERT INTO container (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x, y, isreusable, istemplate, status, containertype_fk, fillpattern_fk, layout_fk, location_fk, container_fk) VALUES (199529, 'adminuser', '2010-10-25 11:53:05.286', NULL, NULL, '', 'Proj1_box1_aaa1', 'Proj1_box1_aaa1', 0, 0, false, false, 'ACTIVE', 9072, NULL, 100508, 100174, NULL);


--
-- TOC entry 2987 (class 0 OID 3742239)
-- Dependencies: 1945 2941
-- Data for Name: molecularspecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO molecularspecimen (id) VALUES (100625);
INSERT INTO molecularspecimen (id) VALUES (100626);
INSERT INTO molecularspecimen (id) VALUES (100631);
INSERT INTO molecularspecimen (id) VALUES (100633);
INSERT INTO molecularspecimen (id) VALUES (100634);
INSERT INTO molecularspecimen (id) VALUES (100635);
INSERT INTO molecularspecimen (id) VALUES (100636);
INSERT INTO molecularspecimen (id) VALUES (100639);


--
-- TOC entry 3016 (class 0 OID 3742335)
-- Dependencies: 1974 2987
-- Data for Name: nucleicacid; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO nucleicacid (id) VALUES (100634);
INSERT INTO nucleicacid (id) VALUES (100635);
INSERT INTO nucleicacid (id) VALUES (100636);


--
-- TOC entry 3042 (class 0 OID 3742500)
-- Dependencies: 2000 2947
-- Data for Name: specimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100625, 'superuser1', '2010-10-07 14:55:17.573', NULL, NULL, '', 'DemoAntibody1', 'DemoAntibody1', '', 'good', NULL, NULL, '', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100630, 'superuser1', '2010-10-07 16:06:01.043', '2010-10-07 16:06:55.082', 'superuser1', 'A test fluid specimen', 'serum_1', 'serum_specimen_1', 'active', 'poor', true, '2010-10-03 00:00:00', 'serological testing', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100634, 'superuser1', '2010-10-07 16:26:11.038', NULL, NULL, 'A PCR primer', 'primer_f1', 'EGFR_PCR_primer_f1', 'active', 'good', true, '2010-09-01 00:00:00', 'PCR amplification of EGFR', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100635, 'superuser1', '2010-10-07 16:27:52.494', NULL, NULL, 'A PCR primer', 'primer_r1', 'EGFR_PCR_primer_r1', 'active', 'good', true, '2010-09-01 00:00:00', 'PCR amplification of EGFR', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100636, 'superuser1', '2010-10-07 16:29:42.561', '2010-10-07 16:31:15.29', 'superuser1', 'PCR amplifiied human EGFR exon 3', 'EGFR_exon_3', 'EGFR_exon_3', 'active', 'good', true, '2010-09-27 00:00:00', 'sequencing template', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100637, 'superuser1', '2010-10-07 16:34:02.149', NULL, NULL, 'Non-small cell lung carcinoma tissue', 'lung_cancer_1', 'lung_cancer_sample_1', 'active', 'good', true, '2010-08-12 00:00:00', 'DNA extraction', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100633, 'superuser1', '2010-10-07 16:21:27.195', '2010-10-07 16:45:44.115', 'superuser1', 'linoleic acid', 'lipid_1', 'lipid_sample_1', 'active', 'good', true, '2010-10-02 00:00:00', '', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100639, 'superuser1', '2010-10-07 16:49:22.95', NULL, NULL, 'Anti-cancer compound', 'doxorubicin', 'doxorubicin', 'active', 'good', true, '2010-07-12 00:00:00', 'chemotherapy', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100629, 'superuser1', '2010-10-07 15:48:35.664', '2010-10-07 16:55:50.22', 'superuser1', 'colon cancer cell line', 'HCT-116', 'HCT-116', 'active', 'good', true, '2010-07-16 00:00:00', 'transfection host', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100631, 'superuser1', '2010-10-07 16:09:23.014', '2010-10-07 16:57:01.281', 'superuser1', 'glutathione-S transferase Mu 1', 'GSTM1_1', 'GSTM1_specimen_1', 'active', 'good', true, '2010-09-20 00:00:00', 'activity assay', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100640, 'superuser1', '2010-10-07 16:51:10.095', '2010-10-11 22:53:12.101', 'superuser1', 'quantum dot', 'nano_1', 'nanomaterial_1', 'active', 'good', false, '2010-10-02 00:00:00', 'cellular imaging', NULL, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100552, 'superuser1', '2010-10-21 22:04:05.738', NULL, NULL, 'Mouse_2001', 'Mouse_2001', 'Mouse_2001', '', 'good', false, '2010-10-21 00:00:00', '', 100551, NULL);
INSERT INTO specimen (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, activitystatus, condition, isavailable, receiveddatetime, use, container_fk, specimen_fk) VALUES (100626, 'superuser1', '2010-10-07 14:57:40.23', '2010-10-22 13:46:00.313', 'superuser1', 'A test antibody', 'ab_1', 'antibody_1', 'active', 'good', true, '2010-08-18 00:00:00', 'tissue microarray', NULL, NULL);


--
-- TOC entry 2953 (class 0 OID 3742013)
-- Dependencies: 1911 3057 3057 3016 3042 3043 2936 2944
-- Data for Name: characteristics; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2945 (class 0 OID 3741952)
-- Dependencies: 1903 3057
-- Data for Name: collaboration; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO collaboration (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, role_fk, type_fk) VALUES (100189, 'superuser1', '2010-08-23 18:52:14.587', NULL, NULL, '', 'Test Collaboration', 'Test Collaboration', 'ACTIVE', NULL, 100136);


--
-- TOC entry 2950 (class 0 OID 3741992)
-- Dependencies: 1908
-- Data for Name: contract; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2952 (class 0 OID 3742005)
-- Dependencies: 1910 3057 2931
-- Data for Name: customerrequest; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (100203, 'superuser1', '2010-08-23 23:25:04.283', '2010-08-23 23:25:52.652', 'superuser1', 'Customer request R-002 for SNP6 Assay - SNP and CNV.', 'Demo R-002', 'Demo Request 002', NULL, NULL, NULL, NULL, 'APPROVALPENDING', '2010-08-22 00:00:00', 100201, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (100205, 'superuser1', '2010-08-23 23:45:01.668', NULL, NULL, 'Customer request from an external laboratory.', 'Demo R-003', 'Demo Request 003', NULL, NULL, NULL, NULL, 'APPROVALPENDING', '2010-08-15 00:00:00', 100204, 100009, 100094);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (100202, 'superuser1', '2010-08-23 23:23:10.439', '2010-08-24 17:36:23.958', 'superuser1', 'Customer Request R-001 for demonstration.', 'Demo R-001', 'Demo Request 001', NULL, NULL, NULL, NULL, 'APPROVED', '2010-08-21 00:00:00', 100201, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (100224, 'customer2', '2010-08-24 17:35:24.364', '2010-08-24 17:36:30.226', 'superuser1', '', 'Customer req 2', 'Customer req 2', NULL, NULL, NULL, NULL, 'APPROVED', NULL, 100204, 100009, 100094);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (100187, 'customer1', '2010-08-23 18:41:58.094', '2010-08-25 03:05:52.937', 'superuser1', 'Demo request R-004.', 'Demo R-004', 'Demo Request 004', '2010-08-04 00:00:00', '2010-08-08 00:00:00', '2010-08-07 00:00:00', '2010-08-21 00:00:00', 'COMPLETED', '2010-07-31 00:00:00', 100132, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (199533, 'superuser1', '2010-10-27 17:01:20.948', NULL, NULL, 'NewCustomerRequest-002 for sample 2', 'NewCustomerRequest-002', 'NewCustomerRequest-002', NULL, NULL, NULL, NULL, 'APPROVALPENDING', '2010-10-27 00:00:00', 100201, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (199534, 'superuser1', '2010-10-27 17:02:04.838', NULL, NULL, 'NewCustomerRequest-002 for sample 2.', 'NewCustomerRequest-002', 'NewCustomerRequest-002', NULL, NULL, NULL, NULL, 'APPROVALPENDING', '2010-10-27 00:00:00', 100201, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (199532, 'superuser1', '2010-10-27 17:01:14.17', '2010-10-27 17:44:45.867', 'superuser1', 'NewCustomerRequest-002 for sample 2', 'NewCustomerRequest-002', 'NewCustomerRequest-002', NULL, NULL, NULL, NULL, 'SUBMITTED', '2010-10-27 00:00:00', 100201, 100008, 100093);
INSERT INTO customerrequest (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, completeddate, invoicedate, laboratoryfinalapprovedate, paymentdate, status, submissiondate, account_fk, person_fk, type_fk) VALUES (199531, 'superuser1', '2010-10-27 16:58:30.834', '2010-10-27 19:08:46.383', 'superuser1', 'NewCustomerRequest-001', 'NewCustomerRequest-001', 'NewCustomerRequest-001', NULL, NULL, NULL, NULL, 'MODIFIED', '2010-10-27 00:00:00', 100201, 100008, 100093);


--
-- TOC entry 2960 (class 0 OID 3742054)
-- Dependencies: 1918 3057
-- Data for Name: equipment; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100145, 'superuser1', '2010-08-21 19:24:32.619', '2010-08-24 14:59:49.589', 'superuser1', 'Demo equipment - HiSpeed centrifuge', 'Demo HS Centriguge OS', 'Demo Equipment1 OS', 'B10XL', 'Demo456789', '1212-xss-223-s', 'INREPAIR', 100131, 100208, 100067);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100213, 'superuser1', '2010-08-24 15:03:16.537', NULL, NULL, 'Affymetrix  GeneChip Scanner model 3000 which supports the current Affymetrix GeneChip Array .', 'AFGS3000-2', 'Affymetrix GeneScanner 3000-2', '3000', '1726354', 'AFSN654', 'ACTIVE', 100131, NULL, 100064);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100215, 'superuser1', '2010-08-24 15:27:02.049', NULL, NULL, 'Affymetrix Fluidcs Workstation used in GeneChip Array experiments.', 'Demo AFFW-1', 'Affymetrix Fluidics Workstation 1', 'FX460', '9080706', 'AFFW123456', 'ACTIVE', 100131, 100208, 100214);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100217, 'superuser1', '2010-08-24 15:38:22.233', NULL, NULL, 'Applied Biosytems automated capillary sequencer - 96/384 well configuration - sequencing/genotyping.', 'AB3730XL-1', 'Applied Biosystems Automated Sequencer 3730XL-1', '3730XL', '1234567', 'AB3456', 'ACTIVE', 100131, 100208, 100063);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100531, 'superuser1', '2010-10-21 19:27:48.4', '2010-10-21 19:28:33.432', 'superuser1', 'Cryo Bio System Liquid Nitrogen Freezer (-150 oC)', 'LN2-Freezer_003', 'LN2-Freezer_003', 'Digicool', NULL, 'SNdemo1234', 'ACTIVE', 100183, 100200, 100062);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100529, 'superuser1', '2010-10-21 19:16:16.217', '2010-10-22 13:40:24.037', 'superuser1', 'A -80 freezer #001.', 'Freezer-80_0001', 'Freezer-80_0001', 'Sanyo U5', NULL, 'SNdemo0001', 'ACTIVE', 100183, 100200, 100059);
INSERT INTO equipment (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, model, propertyid, serialnumber, status, laboratory_fk, location_fk, type_fk) VALUES (100530, 'superuser1', '2010-10-21 19:18:50.46', '2010-10-22 16:19:23.608', 'superuser1', 'Coldbox (+4 oC) #0002', 'Coldbox+4_0002', 'Coldbox+4_0002', 'Sanyo M4', NULL, 'SNdemo_0002', 'ACTIVE', 100183, 100200, 100061);


--
-- TOC entry 2968 (class 0 OID 3742108)
-- Dependencies: 1926 3057 3042 2936
-- Data for Name: feature; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2979 (class 0 OID 3742187)
-- Dependencies: 1937 3057 2947
-- Data for Name: labsupply; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO labsupply (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, status, container_fk, type_fk) VALUES (100554, 'superuser1', '2010-10-21 22:10:43.812', NULL, NULL, 'Gloves, latex-free, medium size', 'Gloves, latex-free, medium', 'Gloves, latex-free, medium', NULL, 'DEFAULT', NULL, 100547);
INSERT INTO labsupply (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, status, container_fk, type_fk) VALUES (100555, 'superuser1', '2010-10-21 22:11:51.854', '2010-10-21 22:13:22.801', 'superuser1', 'Affymetrix U133A', 'Affymetrix U133A', 'Affymetrix U133A', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\001-:\\313\\360\\200sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\022\\000\\020America/New_Yorkxx', 'DEFAULT', NULL, 100550);
INSERT INTO labsupply (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, status, container_fk, type_fk) VALUES (100556, 'superuser1', '2010-10-21 22:12:37.374', '2010-10-21 22:13:52.401', 'superuser1', 'Affymetrix U133B', 'Affymetrix U133B', 'Affymetrix U133B', '\\254\\355\\000\\005sr\\000\\026org.joda.time.DateTime\\270<xdj[\\335\\371\\002\\000\\000xr\\000\\037org.joda.time.base.BaseDateTime\\377\\377\\371\\341O].\\243\\002\\000\\002J\\000\\007iMillisL\\000\\013iChronologyt\\000\\032Lorg/joda/time/Chronology;xp\\000\\000\\001-\\332q\\024\\200sr\\000''org.joda.time.chrono.ISOChronology$Stub\\251\\310\\021fq7P''\\003\\000\\000xpsr\\000\\037org.joda.time.DateTimeZone$Stub\\246/\\001\\232|2\\032\\343\\003\\000\\000xpw\\022\\000\\020America/New_Yorkxx', 'DEFAULT', NULL, 100550);


--
-- TOC entry 3023 (class 0 OID 3742382)
-- Dependencies: 1981 2987
-- Data for Name: protein; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO protein (classgroup, id) VALUES ('', 100625);
INSERT INTO protein (classgroup, id) VALUES ('', 100626);
INSERT INTO protein (classgroup, id) VALUES ('', 100631);


--
-- TOC entry 3036 (class 0 OID 3742455)
-- Dependencies: 1994 3016 2968 2953 2936 2968 2935 3023
-- Data for Name: sequence; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2961 (class 0 OID 3742062)
-- Dependencies: 1919 3057 3042 3036 2979 2931 2952
-- Data for Name: externalidentifier; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO externalidentifier (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, source, value, account_fk, customerrequest_fk, labsupply_fk, person_fk, sequence_fk, specimen_fk, type_fk) VALUES (100553, 'superuser1', '2010-10-21 22:05:43.641', NULL, NULL, 'demo external ID for JAXID_demo456', 'JAXID_demo456', 'JAXID_demo456', 'JAX', 'demo456', NULL, NULL, NULL, NULL, NULL, 100552, NULL);


--
-- TOC entry 3020 (class 0 OID 3742361)
-- Dependencies: 1978 2961 3042 2939 2979 2939
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100004, 'adminuser', '2010-08-17 21:31:05.669', '2010-08-23 23:03:35.225', 'superuser1', NULL, 'MS', '', '', 'Lab Manager User 1', 'User', 'Lab Manager', '', '', '', '', 'ACTIVE', '', '', NULL, 'labmanager1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100006, 'adminuser', '2010-08-17 21:33:36.392', '2010-09-11 17:44:12.657', 'superuser1', NULL, 'BS', '', '', 'Researcher User 1', 'User', 'researcher', '', '', '', '', 'ACTIVE', '', '', NULL, 'labresearcher1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100007, 'adminuser', '2010-08-17 21:35:07.181', '2010-09-11 17:47:29.324', 'superuser1', NULL, 'PhD', '', '', 'Guest User 1', 'User', 'Guest 1', '', '', '', '', 'ACTIVE', '', '', NULL, 'guest1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100003, 'adminuser', '2010-08-17 21:29:45.435', '2010-09-11 18:06:37.33', 'superuser1', NULL, 'MS', '', '', 'Super User 1', 'User', 'Super', '', '', '', '', 'ACTIVE', '', '', NULL, 'superuser1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100009, 'adminuser', '2010-08-17 21:37:37.749', '2010-09-12 20:27:50.373', 'superuser1', NULL, 'MS', '', '', 'Customer 2 User', 'User', 'customer2', '', '', '', '', 'ACTIVE', '', '', NULL, 'customer2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO person (id, createdby, datecreated, datemodified, modifiedby, usmilitaryrankprefix, academicdegree, certification, clinicallicense, displayname, familyname, givenname, individualgeneologysuffix, maidenname, middlename, nameprefix, status, suffix, title, trainingandeducationsuffixabr, username, externalidentifier_fk, personbillinginformation_fk, serviceitembillinginformation_fk, specimen_fk, labsupply_fk) VALUES (100008, 'adminuser', '2010-08-17 21:36:47.46', '2010-09-12 20:31:36.658', 'superuser1', NULL, 'MS', '', '', 'Customer 1 User', 'User', 'customer1', '', '', '', '', 'ACTIVE', '', '', NULL, 'customer1', NULL, NULL, NULL, NULL, NULL);


--
-- TOC entry 2980 (class 0 OID 3742195)
-- Dependencies: 1938 3020
-- Data for Name: layout; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100502, 'adminuser', '2010-10-20 11:49:31.213', '2010-10-25 17:30:07.74', 'superuser1', 'single space* used as default layout for tubes, wells, bottles, flasks, etc.', '1x1Default', '1 X 1', 1, 'DIGITS', 1, 'DIGITS', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100504, 'adminuser', '2010-10-20 12:11:20.026', '2010-10-22 10:27:42.69', 'superuser1', 'one row (Y) of 10 spaces/wells (columns) (X)', '1 Row by 10 Columns', '10 x 1', 10, 'DIGITS', 1, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100508, 'adminuser', '2010-10-20 12:33:11.805', '2010-10-22 10:28:19.307', 'superuser1', 'ten rows (Y) of ten spaces/wells (columns) (X)', '10 Rows by 10 Columns', '10 X 10', 10, 'DIGITS', 10, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100511, 'adminuser', '2010-10-20 12:44:59.925', '2010-10-22 10:34:14.851', 'superuser1', 'one row (Y) of 2 spaces/wells (columns) (X)', '1 Row by 2 Columns', '1 X 2', 2, 'DIGITS', 1, 'ALL_UPPER_CASE', NULL);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100501, 'adminuser', '2010-10-20 11:07:33.893', '2010-10-22 10:37:25.155', 'superuser1', 'eight rows (Y) of 12 spaces/wells (columns) (X)', '8 Rows x 12 Columns', '12 X 8', 12, 'DIGITS', 8, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100509, 'adminuser', '2010-10-20 12:36:08.469', '2010-10-22 10:37:44.426', 'superuser1', 'one row (Y) of 12 spaces/wells (columns) (X)', '1 Row x 12 Columns', '12 X 1', 12, 'DIGITS', 1, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100512, 'adminuser', '2010-10-20 12:46:54.924', '2010-10-22 10:38:51.803', 'superuser1', 'one row (Y) of 4 spaces/wells (columns) (X)', '1 Row by 4 Columns', '1 X 4', 4, 'DIGITS', 1, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100515, 'adminuser', '2010-10-20 12:56:14.986', '2010-10-22 10:39:17.969', 'superuser1', 'one row (Y) of 8 spaces/wells (columns) (X)', '1 Row by 8 Columns', '1 x 8', 8, 'DIGITS', 1, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100503, 'adminuser', '2010-10-20 12:07:37.393', '2010-10-22 10:40:04.014', 'superuser1', '16 rows (Y) of 24 spaces/wells columns) (X)', '16 Rows by 24 Columns', '24 X 16', 24, 'DIGITS', 16, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100513, 'adminuser', '2010-10-20 12:51:24.605', '2010-10-22 10:40:34.866', 'superuser1', 'two rows (Y) of 4 spaces/wells (columns) (X)', '2 Rows by 4 Columns', '2 X 4', 4, 'DIGITS', 2, 'ALL_UPPER_CASE', NULL);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100514, 'adminuser', '2010-10-20 12:53:57.276', '2010-10-22 10:40:57.938', 'superuser1', 'two rows (Y) of 5 spaces/wells (columns) (X)', '2 Rows by 5 Columns', '2 X 5', 5, 'DIGITS', 2, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100510, 'adminuser', '2010-10-20 12:42:24.165', '2010-10-22 10:41:30.923', 'superuser1', '4 rows (Y) of 12 spaces/wells (columns) (X)', '4 Rows by 12 Columns', '4 X 12', 12, 'DIGITS', 4, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100506, 'adminuser', '2010-10-20 12:28:10.37', '2010-10-22 10:42:13.671', 'superuser1', 'four rows (Y) of 6 spaces/wells (columns) (X)****', '4 Rows By 6 Coloumns', '6 X 4', 6, 'DIGITS', 4, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100516, 'adminuser', '2010-10-20 12:57:53.418', '2010-10-22 10:42:37.831', 'superuser1', 'six rows (Y) of 8 spaces/wells (columns) (X)', '6 Rows by 8  Columns', '6 X 8', 8, 'DIGITS', 6, 'ALL_UPPER_CASE', 100004);
INSERT INTO layout (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, x_dimension, x_dimensionlabel, y_dimension, y_dimensionlabel, person_fk) VALUES (100507, 'adminuser', '2010-10-20 12:31:19.2', '2010-10-22 10:43:00.619', 'superuser1', 'nine rows (Y) of nine spaces/wells (columns) (X)', '9 Rows by 9 Columns', '9 By 9', 9, 'DIGITS', 9, 'ALL_UPPER_CASE', 100004);


--
-- TOC entry 3044 (class 0 OID 3742513)
-- Dependencies: 2002 2960
-- Data for Name: storagedevice; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO storagedevice (id) VALUES (100529);
INSERT INTO storagedevice (id) VALUES (100530);
INSERT INTO storagedevice (id) VALUES (100531);


--
-- TOC entry 3045 (class 0 OID 3742518)
-- Dependencies: 2003 3057 3044 2980 3020
-- Data for Name: storagespace; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100212, 'superuser1', '2010-08-24 14:45:37.449', '2010-10-21 20:02:21.337', 'superuser1', 'Storage space in building 90 Room D701 reagent cabinet and shelf 1.', '90D701C3S1', '90D701C3S1', 'ACTIVE', 100004, 100502, 100076, NULL);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100536, 'superuser1', '2010-10-21 20:15:13.198', '2010-10-21 20:22:35.671', 'superuser1', 'second shelf of set of shelves', 'shelf2', 'Shelf2', 'ACTIVE', 100004, 100502, 100076, NULL);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100537, 'superuser1', '2010-10-21 20:16:12.64', '2010-10-21 20:23:13.252', 'superuser1', 'Third shelf of set of shelves', 'shelf3', 'Shelf3', 'ACTIVE', 100004, 100502, 100076, NULL);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100538, 'superuser1', '2010-10-21 20:17:05.652', '2010-10-21 20:23:39.625', 'superuser1', 'Fourth shelf of set of shelves', 'shelf4', 'Shelf4', 'ACTIVE', 100004, 100502, 100076, NULL);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100535, 'superuser1', '2010-10-21 20:13:58.257', '2010-10-21 20:21:48.853', 'superuser1', 'First shelf (top)', 'shelf1', 'Shelf1(top)', 'ACTIVE', 100004, 100502, 100076, 100529);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100540, 'superuser1', '2010-10-21 20:20:23.191', '2010-10-21 20:24:22.767', 'superuser1', 'Second compartment - Lower', 'compartment2L', 'Compartment2-Lower', 'ACTIVE', 100004, 100511, 100077, 100530);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100539, 'superuser1', '2010-10-21 20:19:12.292', NULL, NULL, 'Compartment 1 - Upper compartment', 'compartment1U', 'Compartment1-Upper', 'ACTIVE', 100004, 100511, 100077, 100530);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100211, 'superuser1', '2010-08-24 14:11:37.209', '2010-10-22 17:43:39.65', 'superuser1', 'Storage space in building 90 room D702 Quadrant 2 and shelf 4.', '90D702Q2S4', '90D702Q2S4', 'ACTIVE', 100004, 100502, 100076, NULL);
INSERT INTO storagespace (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, person_fk, layout_fk, type_fk, storagedevice_fk) VALUES (100209, 'superuser1', '2010-08-24 14:07:45.361', '2010-10-22 17:44:09.554', 'superuser1', 'Storage space in Building 90 Room D702 Quadrant 4 and shelf 3.', '90D702Q4S3', '90D702Q4S3', 'ACTIVE', 100004, 100502, 100076, NULL);


--
-- TOC entry 2982 (class 0 OID 3742211)
-- Dependencies: 1940 3057 3042 2953 3045
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100130, 'superuser1', '2010-08-20 19:50:59.002', NULL, NULL, 'Main campus for NIH', 'NIH-Bethesda', 'NIH Campus - Betheda', 'ACTIVE', '9000 Rockville Pike', NULL, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100155, 'superuser1', '2010-08-23 14:59:51.174', NULL, NULL, 'NIH Building 10', 'Bldg. 10', 'NIH Building 10', 'ACTIVE', 'Building 10', 100130, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100162, 'superuser1', '2010-08-23 15:53:06.069', NULL, NULL, 'Main Campus of Demo U1 - Main Bldg.', 'Demo University1 Location1', 'Demo University 1 Location 1', 'CURRENT', 'Demo University1 Main Camplus Bldg. 1', NULL, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100164, 'labmanager1', '2010-08-23 16:23:48.312', NULL, NULL, 'Main building for Demo University 2', 'Demo University 2 Location 1', 'Demo University 2 Location 1', 'CURRENT', 'Demo University 2 Main Bldg.', NULL, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100166, 'labmanager1', '2010-08-23 16:28:39.538', NULL, NULL, 'Location of University2 Genomics Core Facility', 'Demo Univ2 CF1 Bldg.', 'Demo University 2 Core Facility1', 'ACTIVE', 'University2 CF1 Bldg.', NULL, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100176, 'labmanager1', '2010-08-23 17:30:03.083', NULL, NULL, 'NCI Building at 2115 E. Jefferson St.', 'EJ2115', 'NCI EJ2115 Building', 'ACTIVE', '2115 E. Jefferson Building', NULL, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100174, 'labmanager1', '2010-08-23 17:23:53.51', NULL, NULL, 'Building 41 on main NIH campus.', 'NIH Bldg. 41', 'NIH Building 41', 'ACTIVE', 'NIH Bldg. 41', 100130, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100208, 'superuser1', '2010-08-24 14:07:10.627', NULL, NULL, 'A demo building on NIH Bethesda campus.', 'NIH Building 90', 'NIH Building 90', 'ACTIVE', 'NIH Bldg. 90', 100130, 100126, NULL, NULL, NULL);
INSERT INTO location (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, value, location_fk, type_fk, travelhistory_fk, specimen_fk, storagespace_fk) VALUES (100200, 'superuser1', '2010-08-23 23:14:06.659', NULL, NULL, 'Building for Core Facility1', 'Demo Univ1 Core Facility1 Location', 'Demo University 1 Core Facility 1 Location', 'ACTIVE', 'Core Facility Bldg. 1A', 100162, 100126, NULL, NULL, NULL);


--
-- TOC entry 3017 (class 0 OID 3742340)
-- Dependencies: 1975 3057 2982 2945
-- Data for Name: organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100160, 'superuser1', '2010-08-23 15:30:11.233', '2010-08-23 15:31:37.631', 'superuser1', 'NIH - seek fundamental knowledge about nature & behavior of living systems; reduce burden of disease', 'NIH', 'National Institutes of Health', '121121121', '', true, 'Federal Government', 'ACTIVE', '121121121', 100130, NULL, 100156, NULL);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100001, 'adminuser', '2010-08-17 15:04:14.827', '2010-08-23 15:30:38.753', 'superuser1', 'Demo test organization1', 'Test Organization1', 'Test Organization 1', '111111111', 'demo1idnumber', true, 'Federal Government', 'ACTIVE', '222222222', 100155, 100160, 100000, NULL);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100161, 'superuser1', '2010-08-23 15:40:47.966', NULL, NULL, 'NCI leads a national effort to eliminate the suffering and death due to cancer.', 'NCI', 'National Cancer Institute', '', '', true, 'Federal Government', 'ACTIVE', '', 100155, 100160, 100156, NULL);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100173, 'labmanager1', '2010-08-23 17:11:10.816', NULL, NULL, 'More than 250 scientists and clinicians working in intramural research at NCI.', 'CCR', 'Center for Cancer Research', '', '', true, 'Federal Government', 'ACTIVE', '', 100155, 100161, 100156, NULL);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100175, 'labmanager1', '2010-08-23 17:24:30.934', NULL, NULL, 'A Laboratory in the NCI/CCR that utilizes genetic analysis to gain insight into biologic processes.', 'LPG', 'Laboratory of Population Genetics', '', '', true, 'Federal Government', 'ACTIVE', '', 100174, 100173, 100156, 100189);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100165, 'labmanager1', '2010-08-23 16:23:56.654', NULL, NULL, 'Another University for demonstration.', 'Demo University2', 'Demo University 2', '343343343', '', false, 'Education', 'ACTIVE', '909909909', 100164, NULL, 100158, 100189);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100223, 'superuser1', '2010-08-24 17:18:37.599', '2010-09-12 21:05:49.179', 'superuser1', '', 'Test Organization 2', 'Test Organization 2', '', '', NULL, '', 'ACTIVE', '', 100176, 100001, 100157, NULL);
INSERT INTO organization (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, dunsnumber, identifiernumber, istaxexempt, legalcategorytype, status, taxidentifiernumber, location_fk, organization_fk, type_fk, collaboration_fk) VALUES (100163, 'superuser1', '2010-08-23 15:53:17.453', '2010-10-21 20:00:25.589', 'superuser1', 'A University for demonstration purposes.', 'Demo University1', 'Demo University 1', '131131131', '242242424', false, 'Education', 'ACTIVE', '333333333', 100162, NULL, 100158, 100189);


--
-- TOC entry 3060 (class 0 OID 3742617)
-- Dependencies: 2018 2941
-- Data for Name: wholeorganism; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO wholeorganism (commonname, ethnicitystrain, id) VALUES ('mouse', '', 100552);


--
-- TOC entry 2967 (class 0 OID 3742100)
-- Dependencies: 1925 3057 2982 3042 3060 3020 2947 2979 3017
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2974 (class 0 OID 3742153)
-- Dependencies: 1932 3057 3042 2947 2979
-- Data for Name: hazard; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2976 (class 0 OID 3742166)
-- Dependencies: 1934 3057 2952
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO invoice (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, invoicedate, invoicepaymentdate, status, customerrequest_fk, type_fk) VALUES (100188, 'superuser1', '2010-08-23 18:44:29.474', NULL, NULL, '', 'Aug 2010', 'August 2010 Invoice', '2010-08-31 00:00:00', '2010-09-01 00:00:00', 'DEFAULT', 100187, 100097);


--
-- TOC entry 2978 (class 0 OID 3742179)
-- Dependencies: 1936 2982
-- Data for Name: laboratory; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (10000, 'adminuser', '2010-08-17 13:00:29.432', NULL, NULL, '', 'lab1', 'lab1', 'ACTIVE', NULL);
INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (100180, 'labmanager1', '2010-08-23 17:42:20.501', NULL, NULL, 'The team of bioinformatician that support LPG efforts.', 'LPG Bioinformatics Core', 'LPG Bioinformatics Core', 'ACTIVE', 100176);
INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (100182, 'labmanager1', '2010-08-23 17:45:07.992', NULL, NULL, 'The Laboratory (wet) for LPG.', 'LPG Lab', 'LPG Laboratory', 'ACTIVE', 100174);
INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (100178, 'labmanager1', '2010-08-23 17:38:04.195', '2010-08-23 23:10:44.028', 'superuser1', 'A core facility of Demo university 2.', 'Demo Univ2 CF1', 'Demo University 2 Core Facility1', 'ACTIVE', 100166);
INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (100183, 'labmanager1', '2010-08-23 17:47:17.254', '2010-08-23 23:14:13.521', 'superuser1', 'A core facility at Demo University 1.', 'Demo Univ1 CF1', 'Demo University 1 Core Facility1', 'ACTIVE', 100200);
INSERT INTO laboratory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, location_fk) VALUES (100131, 'superuser1', '2010-08-20 19:51:23.392', '2010-08-24 14:48:34.224', 'superuser1', 'Demo lab 1', 'Laboratory1', 'Laboratory One', 'ACTIVE', 100208);


--
-- TOC entry 2988 (class 0 OID 3742244)
-- Dependencies: 1946 3020 2978
-- Data for Name: namingconvention; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO namingconvention (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, example, grouping, ismandatory, issuggested, isunique, maximumlength, status, type, person_fk, laboratory_fk) VALUES (10001, 'adminuser', '2010-08-17 13:01:38.337', NULL, NULL, '', 'nc1', 'nc1', 'ABC_123', NULL, NULL, NULL, NULL, 7, 'ACTIVE', 0, NULL, 10000);
INSERT INTO namingconvention (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, example, grouping, ismandatory, issuggested, isunique, maximumlength, status, type, person_fk, laboratory_fk) VALUES (100218, 'superuser1', '2010-08-24 15:48:42.185', '2010-08-24 16:04:15.501', 'superuser1', 'This is the naming convention for AF SNP6 plate record files in Project Z.  For more information,', 'AFSNP6PlateRecord_v1', 'NamingConvention_AFSNP6PlateRecord_v1', 'ZZ0017r1', NULL, NULL, NULL, NULL, 100, 'ACTIVE', 0, 100004, 100131);


--
-- TOC entry 3032 (class 0 OID 3742423)
-- Dependencies: 1990 3057 3020
-- Data for Name: rate; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO rate (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, quantity, status, person_fk, type_fk) VALUES (199559, 'superuser1', '2010-10-27 20:14:02.273', NULL, NULL, 'Rate is the cost per unit and Unit can be each (as in # of samples) or hour (as in # of hours consulted or spent doing analysis) or whole (as in a negotiated cost per Project).', 'Rate-costPerHr-50', 'Rate-costPerHr-50', 50, 'DEFAULT', 100004, 100107);
INSERT INTO rate (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, quantity, status, person_fk, type_fk) VALUES (199560, 'superuser1', '2010-10-27 20:15:20.977', NULL, NULL, 'This Rate is $100 per hour.  Rate is the cost per unit and Unit can be each (as in # of samples) or hour (as in # of hours consulted or spent doing analysis) or whole (as in a negotiated cost per Project).  ', 'Rate-costPerHr-100', 'Rate-costPerHr-100', 100, 'DEFAULT', 100004, 100107);


--
-- TOC entry 3031 (class 0 OID 3742415)
-- Dependencies: 1989 3057 3057 3032 3043
-- Data for Name: quotation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3037 (class 0 OID 3742463)
-- Dependencies: 1995 3057
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100193, 'superuser1', '2010-08-23 21:47:33.519', '2010-10-27 19:10:52.613', 'superuser1', 'A Service for Affymetrix SNP6 array assay for Copy Number Variation (CNV).', 'Affymetrix SNP6 - CNV', 'Affymetrix SNP6 Assay for Copy Number Variation', NULL, NULL, 'DEFAULT', 100105);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100195, 'superuser1', '2010-08-23 21:52:06.116', '2010-10-27 19:11:06.328', 'superuser1', 'A Service for Affymetrix SNP6 Array protocol for Human gene expression.', 'Affymetrix U133P2', 'Affymetrix GeneChip Human U133P2', NULL, NULL, 'DEFAULT', 100099);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100192, 'superuser1', '2010-08-23 21:45:59.107', '2010-10-27 19:11:49.713', 'superuser1', 'A Service for Affymetrix SNP6 Array protocol for SNP detection.', 'Affymetrix SNP6 - SNP', 'Affymetrix SNP6 Assay - SNP', NULL, NULL, 'DEFAULT', 100106);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100194, 'superuser1', '2010-08-23 21:49:37.273', '2010-10-27 19:12:33.09', 'superuser1', 'A Service for the Affymetrix SNP6 array method for determining both SNP and CNV.', 'Affymetrix SNP6 - SNP + CNV', 'Affymetrix SNP6 - SNP and CNV', NULL, NULL, 'DEFAULT', 100106);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100197, 'superuser1', '2010-08-23 21:58:30.935', '2010-10-27 19:13:10.51', 'superuser1', 'A Service for  Consultation with Core Facility staff on array-based experimental design.', 'Consultation: Array Experiment Design', 'Consultation: Array-based Experiment Design', NULL, NULL, 'DEFAULT', 100104);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100191, 'superuser1', '2010-08-23 21:42:45.999', '2010-10-27 19:15:17.865', 'superuser1', 'A Service for Quality control tests on DNA: including quantification, purity, uniqueness, etc.', 'DNA Sample Quality Control', 'DNA Sample Quality Control', NULL, NULL, 'DEFAULT', 100100);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100196, 'superuser1', '2010-08-23 21:56:04.917', '2010-10-27 19:18:43.648', 'superuser1', 'A service for directed PCR resequencing (Sanger/BDT) using an Applied Biosystems 3730XL.', 'PCR Seq - AB3730XL', 'PCR Sequencing using  AB 3730XL', NULL, NULL, 'DEFAULT', 100098);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (100190, 'superuser1', '2010-08-23 21:40:02.108', '2010-10-27 19:19:28.436', 'superuser1', 'A service for isolation of genomic DNA from 2 ml (1 ml) of whole blood or buffy coat enriched blood samples.', 'DNA from HBC - QIAamp DNA Blood Midi Kit', 'Purification of DNA from Human Buffy Coat Using QIAamp DNA Blood Midi Kit', NULL, NULL, 'DEFAULT', 100102);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199551, 'superuser1', '2010-10-27 19:23:01.405', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-35Fragment.', 'Sequencing-NexGen-SoLID4-35Frag', 'Sequencing-NexGen-SoLID4-35Fragment', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199552, 'superuser1', '2010-10-27 19:24:52.591', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-50Fragment', 'Sequencing-NexGen-SoLID4-50Frag', 'Sequencing-NexGen-SoLID4-50Fragment', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199553, 'superuser1', '2010-10-27 19:26:25.261', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-35PairedEnd.', 'Sequencing-NexGen-SoLID4-35PairEnd', 'Sequencing-NexGen-SoLID4-35PairedEnd', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199554, 'superuser1', '2010-10-27 19:27:05.604', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-50PairedEnd.', 'Sequencing-NexGen-SoLID4-50PairEnd', 'Sequencing-NexGen-SoLID4-50PairedEnd', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199555, 'superuser1', '2010-10-27 19:28:47.999', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-35MatePair.', 'Sequencing-NexGen-SoLID4-35MatePair', 'Sequencing-NexGen-SoLID4-35MatePair', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199556, 'superuser1', '2010-10-27 19:29:49.448', NULL, NULL, 'A Service for Sequencing-NexGen-SoLID4-50MatePair.', 'Sequencing-NexGen-SoLID4-50MatePair', 'Sequencing-NexGen-SoLID4-50MatePair', NULL, NULL, 'DEFAULT', 199547);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199557, 'superuser1', '2010-10-27 19:33:07.155', NULL, NULL, 'A Service for Sequencing-NexGen-HiSeq-50Fragment.', 'Sequencing-NexGen-HiSeq-50Frag', 'Sequencing-NexGen-HiSeq-50Fragment', NULL, NULL, 'DEFAULT', 199548);
INSERT INTO service (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, startdate, status, type_fk) VALUES (199558, 'superuser1', '2010-10-27 19:34:31.302', NULL, NULL, 'A Service for Sequencing-NexGen-HiSeq-100x100PairedEnd.', 'Sequencing-NexGen-HiSeq-100x100PairEnd', 'Sequencing-NexGen-HiSeq-100x100PairedEnd', NULL, NULL, 'DEFAULT', 199548);


--
-- TOC entry 2958 (class 0 OID 3742041)
-- Dependencies: 1916 2982 3042 2976 2988 2945 2967 3020 2953 3017 3037 2974 2960 2950 3031 2931 2979 2941 2944 3059 2952
-- Data for Name: document; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO document (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, endpage, keywordcode, keywordtext, startpage, status, title, universalresourcelocator, version, account_fk, biospecimen_fk, characteristics_fk, chemicalcompound_fk, collaboration_fk, contract_fk, customerrequest_fk, equipment_fk, event_fk, fileformatspecification_fk, hazard_fk, invoice_fk, labsupply_fk, location_fk, namingconvention_fk, organization_fk, person_fk, quotation_fk, service_fk, specimen_fk, unit_fk, worksheet_fk) VALUES (100143, 'superuser1', '2010-08-21 19:18:57.5', NULL, NULL, '', 'new doc1', 'New doc1', '', '', '', '', 'CURRENT', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO document (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, endpage, keywordcode, keywordtext, startpage, status, title, universalresourcelocator, version, account_fk, biospecimen_fk, characteristics_fk, chemicalcompound_fk, collaboration_fk, contract_fk, customerrequest_fk, equipment_fk, event_fk, fileformatspecification_fk, hazard_fk, invoice_fk, labsupply_fk, location_fk, namingconvention_fk, organization_fk, person_fk, quotation_fk, service_fk, specimen_fk, unit_fk, worksheet_fk) VALUES (100147, 'superuser1', '2010-08-21 19:31:08.525', NULL, NULL, '', 'test doc1', 'test doc1', '', '', '', '', 'APPROVED', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100003, NULL, NULL, NULL, NULL, NULL);
INSERT INTO document (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, endpage, keywordcode, keywordtext, startpage, status, title, universalresourcelocator, version, account_fk, biospecimen_fk, characteristics_fk, chemicalcompound_fk, collaboration_fk, contract_fk, customerrequest_fk, equipment_fk, event_fk, fileformatspecification_fk, hazard_fk, invoice_fk, labsupply_fk, location_fk, namingconvention_fk, organization_fk, person_fk, quotation_fk, service_fk, specimen_fk, unit_fk, worksheet_fk) VALUES (100198, 'superuser1', '2010-08-23 22:07:24.942', NULL, NULL, 'SOP document for Method: Affymetrix U133P2v1.', 'Method: Affymetrix U133P2v1', 'Method Model for Affymetrix U133p2v1', '5', 'Affymetrix U133P2', 'Affymetrix U133P2, caLIMS, gene expression, SOP', '1', 'APPROVED', 'Method Model for Affymetrix U133p2', 'https://thisIsWhereItIs.xxx', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100195, NULL, NULL, NULL);
INSERT INTO document (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, endpage, keywordcode, keywordtext, startpage, status, title, universalresourcelocator, version, account_fk, biospecimen_fk, characteristics_fk, chemicalcompound_fk, collaboration_fk, contract_fk, customerrequest_fk, equipment_fk, event_fk, fileformatspecification_fk, hazard_fk, invoice_fk, labsupply_fk, location_fk, namingconvention_fk, organization_fk, person_fk, quotation_fk, service_fk, specimen_fk, unit_fk, worksheet_fk) VALUES (100199, 'superuser1', '2010-08-23 22:11:12.704', NULL, NULL, 'SOP for SNP6 for SNP and CNV.', 'Method: SNP6 v1', 'Method Model for Affymetrix SNP 6.0 Array v1', '8', 'Affymetrix SNP6', 'Affymetrix SNP 6.0, SOP, SNP', '1', 'APPROVED', 'Method Model for Affymetrix SNP 6.0 Array', 'https://ThisIsWhereItIs.xxx', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 100194, NULL, NULL, NULL);


--
-- TOC entry 2959 (class 0 OID 3742049)
-- Dependencies: 1917 2960 2958 3045
-- Data for Name: electronicdocument; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2969 (class 0 OID 3742116)
-- Dependencies: 1927 3057 2959
-- Data for Name: fileextension; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2971 (class 0 OID 3742132)
-- Dependencies: 1929
-- Data for Name: filetransporter; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2970 (class 0 OID 3742124)
-- Dependencies: 1928 3057 2971 2969 3020
-- Data for Name: fileformatspecification; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2933 (class 0 OID 3741877)
-- Dependencies: 1891 3057 2958 3020 2970
-- Data for Name: adapter; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2934 (class 0 OID 3741885)
-- Dependencies: 1892 3057 3060
-- Data for Name: additionalorganismname; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2937 (class 0 OID 3741906)
-- Dependencies: 1895 3042
-- Data for Name: artificialspecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO artificialspecimen (id) VALUES (100640);


--
-- TOC entry 2940 (class 0 OID 3741924)
-- Dependencies: 1898 2974
-- Data for Name: biohazard; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2942 (class 0 OID 3741934)
-- Dependencies: 1900 2987
-- Data for Name: carbohydrate; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2943 (class 0 OID 3741939)
-- Dependencies: 1901 2941 2947
-- Data for Name: cellspecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO cellspecimen (cellculturegrowthmedium, cellculturegrowthmediumsupple, countofrequests, mycoplasmastatus, passagenumber, targetedmutation, id, container_fk) VALUES ('ATCC complete growth medium', 'none', 2, 'negative', 21, 'none', 100629, NULL);


--
-- TOC entry 2954 (class 0 OID 3742021)
-- Dependencies: 1912 2978 2945
-- Data for Name: collaboration_laboratory; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO collaboration_laboratory (collaboration_id, laboratory_id) VALUES (100189, 100180);
INSERT INTO collaboration_laboratory (collaboration_id, laboratory_id) VALUES (100189, 100182);
INSERT INTO collaboration_laboratory (collaboration_id, laboratory_id) VALUES (100189, 100183);
INSERT INTO collaboration_laboratory (collaboration_id, laboratory_id) VALUES (100189, 100178);


--
-- TOC entry 2955 (class 0 OID 3742026)
-- Dependencies: 1913 3020 2945
-- Data for Name: collaboration_person; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO collaboration_person (collaboration_id, person_id) VALUES (100189, 100008);
INSERT INTO collaboration_person (collaboration_id, person_id) VALUES (100189, 100009);
INSERT INTO collaboration_person (collaboration_id, person_id) VALUES (100189, 100003);
INSERT INTO collaboration_person (collaboration_id, person_id) VALUES (100189, 100004);


--
-- TOC entry 2946 (class 0 OID 3741960)
-- Dependencies: 1904 3057 2982 2945 3020 2978 3017
-- Data for Name: contactinformation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO contactinformation (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, uri, emailaddress, rank, status, collaboration_fk, laboratory_fk, location_fk, organization_fk, person_fk, type_fk) VALUES (100139, 'superuser1', '2010-08-21 18:04:32.184', NULL, NULL, '', 'Test Org Contact Info', 'Test Org Contact Info', '', 'test1@test1test1.com', 1, 'ACTIVE', NULL, NULL, NULL, 100001, NULL, 100040);
INSERT INTO contactinformation (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, uri, emailaddress, rank, status, collaboration_fk, laboratory_fk, location_fk, organization_fk, person_fk, type_fk) VALUES (100148, 'superuser1', '2010-08-21 19:32:17.467', NULL, NULL, '', 'test contact1', 'Test contact1', '', 'asfd@asdfasf.com', 1, 'ACTIVE', NULL, NULL, NULL, NULL, 100003, 100040);
INSERT INTO contactinformation (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, uri, emailaddress, rank, status, collaboration_fk, laboratory_fk, location_fk, organization_fk, person_fk, type_fk) VALUES (100168, 'labmanager1', '2010-08-23 16:46:28.985', NULL, NULL, 'Contact information for NIH', 'NIH Contact1', 'NIH Contact Information1', 'http://www.nih.gov/index.html', 'NIHinfo@od.nih.gov', 1, 'CURRENT', NULL, NULL, NULL, 100160, NULL, 100041);
INSERT INTO contactinformation (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, uri, emailaddress, rank, status, collaboration_fk, laboratory_fk, location_fk, organization_fk, person_fk, type_fk) VALUES (100171, 'labmanager1', '2010-08-23 16:55:16.827', NULL, NULL, 'Contact information for NCI.', 'NCI Main Contact Information', 'NCI Main Contact Information', 'http://www.cancer.gov/', 'cancergovstaff@mail.nih.gov', 1, 'ACTIVE', NULL, NULL, NULL, 100161, NULL, 100041);
INSERT INTO contactinformation (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, uri, emailaddress, rank, status, collaboration_fk, laboratory_fk, location_fk, organization_fk, person_fk, type_fk) VALUES (100184, 'superuser1', '2010-08-23 18:19:44.333', NULL, NULL, '', 'customer1 lab contact', 'Customer Lab contact', '', 'customer1@customerorg1.xyz', 1, 'ACTIVE', NULL, NULL, NULL, NULL, 100008, 100038);


--
-- TOC entry 2948 (class 0 OID 3741976)
-- Dependencies: 1906 3057
-- Data for Name: containersubcategory; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9016, NULL, NULL, NULL, NULL, 'Centrifuge', 'Centrifuge', 'Centrifuge', 9005);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9017, NULL, NULL, NULL, NULL, 'Narrow Mouth', 'Narrow Mouth', 'Narrow Mouth', 9005);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9018, NULL, NULL, NULL, NULL, 'Roller', 'Roller', 'Roller', 9005);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9019, NULL, NULL, NULL, NULL, 'Screw Top', 'Screw Top', 'Screw Top', 9005);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9020, NULL, NULL, NULL, NULL, 'Wide Mouth', 'Wide Mouth', 'Wide Mouth', 9005);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9021, NULL, NULL, NULL, NULL, 'Fiberboard', 'Fiberboard', 'Fiberboard', 9004);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9022, NULL, NULL, NULL, NULL, 'Polycarbonate', 'Polycarbonate', 'Polycarbonate', 9004);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9023, NULL, NULL, NULL, NULL, 'Containment', 'Containment', 'Containment', 9006);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9024, NULL, NULL, NULL, NULL, 'Lead-Lined', 'Lead-Lined', 'Lead-Lined', 9006);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9025, NULL, NULL, NULL, NULL, 'Biopsy', 'Biopsy', 'Biopsy', 9060);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9026, NULL, NULL, NULL, NULL, 'Goblet', 'Goblet', 'Goblet', 9060);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9027, NULL, NULL, NULL, NULL, 'Straw', 'Straw', 'Straw', 9060);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9028, NULL, NULL, NULL, NULL, 'Tissue', 'Tissue', 'Tissue', 9060);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9029, NULL, NULL, NULL, NULL, 'Glass', 'Glass', 'Glass', 9007);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9030, NULL, NULL, NULL, NULL, 'Polycarbonate', 'Polycarbonate', 'Polycarbonate', 9007);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9031, NULL, NULL, NULL, NULL, 'Polypropylene', 'Polypropylene', 'Polypropylene', 9007);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9032, NULL, NULL, NULL, NULL, 'PCR', 'PCR', 'PCR', 9008);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9033, NULL, NULL, NULL, NULL, 'Sequencing', 'Sequencing', 'Sequencing', 9008);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9034, NULL, NULL, NULL, NULL, 'Pen', 'Pen', 'Pen', 9009);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9035, NULL, NULL, NULL, NULL, '384-Well', '384-Well', '384-Well', 9010);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9036, NULL, NULL, NULL, NULL, '96-Well', '96-Well', '96-Well', 9010);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9037, NULL, NULL, NULL, NULL, 'Cell Culture', 'Cell Culture', 'Cell Culture', 9010);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9038, NULL, NULL, NULL, NULL, 'Freezer', 'Freezer', 'Freezer', 9011);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9039, NULL, NULL, NULL, NULL, 'Freezer-Goblet', 'Freezer-Goblet', 'Freezer-Goblet', 9011);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9040, NULL, NULL, NULL, NULL, 'Microtube', 'Microtube', 'Microtube', 9011);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9041, NULL, NULL, NULL, NULL, 'Plate', 'Plate', 'Plate', 9011);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9042, NULL, NULL, NULL, NULL, 'Test Tube', 'Test Tube', 'Test Tube', 9011);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9043, NULL, NULL, NULL, NULL, 'Fiberboard', 'Fiberboard', 'Fiberboard', 9012);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9044, NULL, NULL, NULL, NULL, 'Styrofoam', 'Styrofoam', 'Styrofoam', 9012);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9045, NULL, NULL, NULL, NULL, 'Glass', 'Glass', 'Glass', 9013);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9046, NULL, NULL, NULL, NULL, 'CBS', 'CBS', 'CBS', 9013);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9047, NULL, NULL, NULL, NULL, 'Sample Collection', 'Sample Collection', 'Sample Collection', 9014);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9048, NULL, NULL, NULL, NULL, 'Transport', 'Transport', 'Transport', 9014);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9050, NULL, NULL, NULL, NULL, 'Blood Collection', 'Blood Collection', 'Blood Collection', 9014);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9051, NULL, NULL, NULL, NULL, 'Capillary', 'Capillary', 'Capillary', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9052, NULL, NULL, NULL, NULL, 'Centrifuge', 'Centrifuge', 'Centrifuge', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9053, NULL, NULL, NULL, NULL, 'Microtube Flat Top', 'Microtube Flat Top', 'Microtube Flat Top', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9054, NULL, NULL, NULL, NULL, 'Microtube Screw Top', 'Microtube Screw Top', 'Microtube Screw Top', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9055, NULL, NULL, NULL, NULL, 'Microtube Strip', 'Microtube Strip', 'Microtube Strip', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9056, NULL, NULL, NULL, NULL, 'Optical', 'Optical', 'Optical', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9057, NULL, NULL, NULL, NULL, 'Screw Top', 'Screw Top', 'Screw Top', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9058, NULL, NULL, NULL, NULL, 'Ultra Centrifuge', 'Ultra Centrifuge', 'Ultra Centrifuge', 9015);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (9059, NULL, NULL, NULL, NULL, 'Polypropylene', 'Polypropylene', 'Polypropylene', 9004);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (199510, 'superuser1', '2010-10-22 14:19:33.508', NULL, NULL, 'A single ''well'' in a container that cannot be physically separated from the parent container (example a well in a 96-well plate).', 'Well', 'Well', 199509);
INSERT INTO containersubcategory (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, type_fk) VALUES (199517, 'superuser1', '2010-10-22 14:40:50.853', NULL, NULL, 'Visotube is part of the CBS Liquid N2 Freezer System.  A visotubes holds 12-14 straws.  There are 11 visotubes per Goblet and 6 Goblets per Goblet cannister/rack.', 'Visotube', 'Visotube', 9015);


--
-- TOC entry 2949 (class 0 OID 3741984)
-- Dependencies: 1907 2980 2948
-- Data for Name: containertype; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9075, NULL, NULL, NULL, NULL, '10x1, maxVol=10, holds microscope slides', 'box_polycarbonate_MicroSlide_10x1', 'box_polycarbonate_MicroSlide_10x1', 'COMPLEX', NULL, 9022, 100504);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9115, NULL, NULL, NULL, NULL, 'TC plate,4x6, 1 ml maxVol, U-bottom, for tissue culture with Poly-D-Lysine and Collagen I coatings', 'plate_cell culture_4x6_1ml', 'plate_cell culture_4x6_1ml', 'COMPOSITE', NULL, 9037, 100506);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9076, NULL, NULL, NULL, NULL, '9x9, maxVol=81, suitable for freezer storage', 'box_polypropylene_9x9', 'box_polypropylene_9x9', 'COMPLEX', NULL, 9059, 100507);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9074, NULL, NULL, NULL, NULL, '10x10, maxVol=100, polycarb', 'box_polycarbonate_10x10', 'box_polycarbonate_10x10', 'COMPLEX', NULL, 9022, 100508);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9082, NULL, NULL, NULL, NULL, 'holds 10x1 straws', 'cassette_straw_10x1', 'cassette_straw_10x1', 'COMPLEX', NULL, 9027, 100504);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9114, NULL, NULL, NULL, NULL, 'TC plate, 2x4, 4.5 ml maxVol, U-bottom, for tissue culture with Poly-D-Lysine and Collagen I coatings', 'plate_cell culture_2x4_4.5ml', 'plate_cell culture_2x4_4.5ml', 'COMPOSITE', NULL, 9037, 100513);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9116, NULL, NULL, NULL, NULL, 'TC plate,6x8, 600 ul maxVol, U-bottom, for tissue culture with Poly-D-Lysine and Collagen I coatings', 'plate_cell culture_6x8_600ul', 'plate_cell culture_6x8_600ul', 'COMPOSITE', NULL, 9037, 100516);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9060, NULL, NULL, NULL, NULL, '1x1,maxVol = 500 ml', 'bottle_centrifuge_screwTop_500ml', 'bottle_centrifuge_screwTop_500ml', 'SIMPLE', NULL, 9016, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9061, NULL, NULL, NULL, NULL, '1x1, maxVol = 250 ml', 'bottle_centrifuge_screwTop_250ml', 'bottle_centrifuge_screwTop_250ml', 'SIMPLE', NULL, 9016, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9063, NULL, NULL, NULL, NULL, '1x1, maxVol = 500 ml', 'bottle_narrowMouth_screwTop_500ml', 'bottle_narrowMouth_screwTop_500ml', 'SIMPLE', NULL, 9017, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9065, NULL, NULL, NULL, NULL, '1x1, maxVol = 500 ml', 'bottle_roller_screwTop_500ml', 'bottle_roller_screwTop_500ml', 'SIMPLE', NULL, 9018, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9066, NULL, NULL, NULL, NULL, '1x1, maxVol = 250 ml', 'bottle_roller_screwTop_250ml', 'bottle_roller_screwTop_250ml', 'SIMPLE', NULL, 9018, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9067, NULL, NULL, NULL, NULL, '1x1, maxVol = 1 L', 'bottle_roller_screwTop_1L', 'bottle_roller_screwTop_1L', 'SIMPLE', NULL, 9018, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9068, NULL, NULL, NULL, NULL, '1x1, maxVol = 1 L', 'bottle_screwtop_500ml', 'bottle_screwtop_500ml', 'SIMPLE', NULL, 9019, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9120, NULL, NULL, NULL, NULL, 'freezer rack for goblets, 4x8 goblets per rack', 'rack_freezer-goblet_LN2_4x8', 'rack_freezer-goblet_LN2_4x8', 'COMPLEX', NULL, 9039, NULL);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9117, NULL, NULL, NULL, NULL, '96-well plate, 250 ul maxVol,U-bottom, for tissue culture with Poly-D-Lysine and Collagen I coatings', 'plate_cell culture_96_250ul', 'plate_cell culture_96_250ul', 'COMPOSITE', NULL, 9037, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9122, NULL, NULL, NULL, NULL, 'microtube rack, 8x12, for 200 ul tubes', 'rack_microtube_8x12_200ul', 'rack_microtube_8x12_200ul', 'COMPLEX', NULL, 9040, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9118, NULL, NULL, NULL, NULL, 'freezer rack, 4x6 slots for 2 in boxes', 'rack_freezer_4x6_box2in', 'rack_freezer_4x6_box2in', 'COMPLEX', NULL, 9038, 100506);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9119, NULL, NULL, NULL, NULL, 'freezer rack, 4x6 slots for 1 in boxes', 'rack_freezer_4x6_box1in', 'rack_freezer_4x6_box1in', 'COMPLEX', NULL, 9038, 100506);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9123, NULL, NULL, NULL, NULL, 'freezer rack, 4x6 slots for 96-well  500 ul plates', 'rack_plate_4x6_plt96_500ml', 'rack_plate_4x6_plt96_500ml', 'COMPLEX', NULL, 9041, 100506);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9124, NULL, NULL, NULL, NULL, 'freezer rack, 4x6 slots for 384-well 100 ul plates', 'rack_plate_4x6_384_100ul', 'rack_plate_4x6_384_100ul', 'COMPLEX', NULL, 9041, 100506);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9121, NULL, NULL, NULL, NULL, 'microtube rack, 4x12, for 1.5-2.0 ml tubes', 'rack_microtube_4x12_2.0ml', 'rack_microtube_4x12_2.0ml', 'COMPLEX', NULL, 9040, 100510);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9126, NULL, NULL, NULL, NULL, 'test tube rack, 4x12, for 15 ml tubes', 'rack_test tube_4x12_15ml', 'rack_test tube_4x12_15ml', 'COMPLEX', NULL, 9042, 100510);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9130, NULL, NULL, NULL, NULL, 'glass straw which stores 4 aliquots of 10 ul each', 'straw_glass_4x1_10ul', 'straw_glass_4x1_10ul', 'COMPLEX', NULL, 9045, 100512);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9125, NULL, NULL, NULL, NULL, 'test tube rack, 2x5, for 50 ml tubes', 'rack_test tube_2x5_50ml', 'rack_test tube_2x5_50ml', 'COMPLEX', NULL, 9042, 100514);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9097, NULL, NULL, NULL, NULL, 'pen used for animals; subdivided into 2 compartments', 'pen_pen_Pen_2x1', 'pen_pen_Pen_2x1', 'COMPLEX', NULL, 9034, 100511);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9070, NULL, NULL, NULL, NULL, '1x1, maxVol = 1 L', 'bottle_screwtop_1L', 'bottle_screwtop_1L', 'SIMPLE', NULL, 9019, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9072, NULL, NULL, '2010-10-22 14:32:50.632', 'superuser1', '10x10, maxVol=100, fiberboard', 'box_fiberboard_10x10', 'box_fiberboard_10x10', 'COMPLEX', 9153, 9021, NULL);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9073, NULL, NULL, '2010-10-22 14:34:04.098', 'superuser1', 'BxF9x9,box_fiberboard_9x9,9x9, maxVol=81, fiberboard suitable for cold/freezer storage', 'box_fiberboard_9x9', 'box_fiberboard_9x9', 'COMPLEX', 9154, 9021, NULL);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9080, NULL, NULL, '2010-10-22 14:50:24.542', 'superuser1', 'Goblet with 12 visotubes (for straws) per goblet', 'cassette_goblet_12_1', 'cassette_goblet_12_1', 'COMPLEX', 199518, 9039, NULL);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9077, NULL, NULL, NULL, NULL, 'infectious containment cannister for up to 10 ml volumes, maxVol=10 ml', 'cannister_containment_infectious_1x1_10ml', 'cannister_containment_infectious_1x1_10ml', 'COMPLEX', NULL, 9023, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9078, NULL, NULL, NULL, NULL, 'lead-lined cannister for radioactive storage', 'cannister_leadlined_1x1', 'cannister_leadlined_1x1', 'COMPLEX', NULL, 9024, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9102, NULL, NULL, '2010-10-29 14:07:33.02', 'adminuser', '384-well plate, 100 ul maxVol, Filter type 2, for BDT rxn cleanup', 'plate_384-well_Filter2_100ul', 'plate_384-well_Filter2_100ul', 'COMPOSITE', 199512, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9101, NULL, NULL, '2010-10-29 14:08:17.849', 'adminuser', '384-well plate, 100 ul maxVol, Filter type 1, for PCR cleanup', 'plate_384-well_Filter1_100ul', 'plate_384-well_Filter1_100ul', 'COMPOSITE', 199512, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9103, NULL, NULL, '2010-10-29 14:10:03.728', 'adminuser', '384-well plate, 50 ul maxVol, flat-bottom, for optical scanning, clear', 'plate_384-well_OpticalC_50ul', 'plate_384-well_OpticalC_50ul', 'COMPOSITE', 199511, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9104, NULL, NULL, '2010-10-29 14:10:46.965', 'adminuser', '384-well plate, 50 ul maxVol, flat-bottom, for optical scanning, white', 'plate_384-well_OpticalW_50ul', 'plate_384-well_OpticalW_50ul', 'COMPOSITE', 199511, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9109, NULL, NULL, '2010-10-29 14:11:19.298', 'adminuser', '96-well plate, 200 ul maxVol, Filter type 1, for PCR cleanup', 'plate_96-well_Filter1_200ul', 'plate_96-well_Filter1_200ul', 'COMPOSITE', 199513, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9110, NULL, NULL, '2010-10-29 14:12:08.112', 'adminuser', '96-well plate, 200 ul maxVol, Filter type 2, for sequencing rxn cleanup', 'plate_96-well_Filter2_200ul', 'plate_96-well_Filter2_200ul', 'COMPOSITE', 199513, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9107, NULL, NULL, '2010-10-29 14:12:29.864', 'adminuser', '96-well plate, 200 ul maxVol, V-bottom, for PCR instruments', 'plate_96-well_PCR_200ul', 'plate_96-well_PCR_200ul', 'COMPOSITE', 199513, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9106, NULL, NULL, '2010-10-29 14:12:56.836', 'adminuser', '96-well plate, 200 ul maxVol, U-bottom, for storage', 'plate_96-well_Storage_200ul', 'plate_96-well_Storage_200ul', 'COMPOSITE', 199513, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9111, NULL, NULL, '2010-10-29 14:13:22.964', 'adminuser', '96-well plate, 2.0 ml maxVol, U-bottom, for storage', 'plate_96-well_Storage_2ml', 'plate_96-well_Storage_2ml', 'COMPOSITE', 199516, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9108, NULL, NULL, '2010-10-29 14:21:36.339', 'adminuser', '96-well plate, 500 ul maxVol, U-bottom, for storage', 'plate_96-well_Storage_500ul', 'plate_96-well_Storage_500ul', 'COMPOSITE', 199562, 9036, 100501);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9098, NULL, NULL, '2010-10-29 14:24:57.328', 'adminuser', '384-welll plate, 120 ul maxVol, U-bottom, for storage', 'plate_384-well_Storage_120ul', 'plate_384-well_Storage_120ul', 'COMPOSITE', 199563, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9100, NULL, NULL, '2010-10-29 14:25:16.183', 'adminuser', '384-well plate, 240 ul maxVol, U-bottom, for storage', 'plate_384-well_Storage_240ul', 'plate_384-well_Storage_240ul', 'COMPOSITE', 199564, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9079, NULL, NULL, NULL, NULL, 'holds biopsy samples for storage', 'cassette_biopsy_1x1', 'cassette_biopsy_1x1', 'SIMPLE', NULL, 9025, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9083, NULL, NULL, NULL, NULL, 'holds tissue samples for embedding', 'cassette_tissue_1x1', 'cassette_tissue_1x1', 'COMPLEX', NULL, 9028, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9084, NULL, NULL, NULL, NULL, '1x1, maxVol=2L, glass flask', 'flask_glass_2L', 'flask_glass_2L', 'SIMPLE', NULL, 9029, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9085, NULL, NULL, NULL, NULL, '1x1, maxVol=1L, glass flask', 'flask_glass_1L', 'flask_glass_1L', 'SIMPLE', NULL, 9029, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9086, NULL, NULL, NULL, NULL, '1x1, maxVol=2L, polycarbonate flask', 'flask_polycarbonate_2L', 'flask_polycarbonate_2L', 'SIMPLE', NULL, 9030, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9087, NULL, NULL, NULL, NULL, '1x1, maxVol=2L, polypropylene flask', 'flask_polypropylene_2L', 'flask_polypropylene_2L', 'SIMPLE', NULL, 9031, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9088, NULL, NULL, NULL, NULL, 'kit for RT-PCR from AB', 'kit_PCR_PCR-RT-AB', 'kit_PCR_PCR-RT-AB', 'SIMPLE', NULL, 9032, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9089, NULL, NULL, NULL, NULL, 'kit for RT-PCR from Qiagen', 'kit_PCR_PCR-RT-Q', 'kit_PCR_PCR-RT-Q', 'SIMPLE', NULL, 9032, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9090, NULL, NULL, NULL, NULL, 'kit for extra-long PCR from AB', 'kit_PCR_PCR-XL-AB', 'kit_PCR_PCR-XL-AB', 'SIMPLE', NULL, 9032, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9091, NULL, NULL, NULL, NULL, 'kit for extra-long PCR from Qiagen', 'kit_PCR_PCR-XL-Q', 'kit_PCR_PCR-XL-Q', 'SIMPLE', NULL, 9032, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9092, NULL, NULL, NULL, NULL, 'kit for BigDye Terminator sequencing', 'kit_sequencing_AB_BDT', 'kit_sequencing_AB_BDT', 'SIMPLE', NULL, 9033, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9093, NULL, NULL, NULL, NULL, 'kit for HT SoLID sequencing', 'kit_sequencing_AB_Solid', 'kit_sequencing_AB_Solid', 'SIMPLE', NULL, 9033, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9094, NULL, NULL, NULL, NULL, 'kit for HT 454 sequencing', 'kit_sequencing_Roche_454', 'kit_sequencing_Roche_454', 'SIMPLE', NULL, 9033, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9095, NULL, NULL, NULL, NULL, 'kit for HT Illumina sequencing', 'kit_sequencing_Illumina_GSX', 'kit_sequencing_Illumina_GSX', 'SIMPLE', NULL, 9033, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9096, NULL, NULL, NULL, NULL, 'pen used for animals; 1 compartment', 'pen_pen_Pen_1x1', 'pen_pen_Pen_1x1', 'COMPLEX', NULL, 9034, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9113, NULL, NULL, NULL, NULL, '10 ml tissue culture plate', 'plate_cell culture_1x1_10ml', 'plate_cell culture_1x1_10ml', 'COMPLEX', NULL, 9037, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9127, NULL, NULL, NULL, NULL, 'shipping container: size 24x36 fiber board - no temperature control', 'shipping_fiberboard_24x36', 'shipping_fiberboard_24x36', 'COMPLEX', NULL, 9043, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9129, NULL, NULL, NULL, NULL, 'shipping container: size 24x36 styrofoam for temperature control', 'shipping_styrofoam_tempControl_24x36', 'shipping_styrofoam_tempControl_24x36', 'COMPLEX', NULL, 9044, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9131, NULL, NULL, NULL, NULL, 'CryoBioSystem straw which stores 1 aliquot of 2.0 ml each', 'straw_CBS_1x1_2.0ml', 'straw_CBS_1x1_2.0ml', 'SIMPLE', NULL, 9046, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9132, NULL, NULL, NULL, NULL, 'CryoBioSystem straw which stores 1 aliquot of 0.3 ml each', 'straw_CBS_1x1_0.3ml', 'straw_CBS_1x1_0.3ml', 'SIMPLE', NULL, 9046, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9133, NULL, NULL, NULL, NULL, 'CryoBioSystem straw which stores 1 aliquot of 0.5 ml each', 'straw_CBS_1x1_0.5ml', 'straw_CBS_1x1_0.5ml', 'SIMPLE', NULL, 9046, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9134, NULL, NULL, NULL, NULL, 'sample collection swab without antibiotics', 'swab_sample collection_NoAntibiotics', 'swab_sample collection_NoAntibiotics', 'SIMPLE', NULL, 9047, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9135, NULL, NULL, NULL, NULL, 'sample collection swab plus antibiotics', 'swab_sample collection_PlusAntibiotics', 'swab_sample collection_PlusAntibiotics', 'SIMPLE', NULL, 9047, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9136, NULL, NULL, NULL, NULL, 'sample transport swab type 1', 'swab_transport_type1', 'swab_transport_type1', 'SIMPLE', NULL, 9048, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9137, NULL, NULL, NULL, NULL, 'sample transport swab type 2', 'swab_transport_Type2', 'swab_transport_Type2', 'SIMPLE', NULL, 9048, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9138, NULL, NULL, NULL, NULL, 'blood collection tube, 15 ml, Red top (separation polymer)', 'tube_blood collection_Red_15ml', 'tube_blood collection_Red_15ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9139, NULL, NULL, NULL, NULL, 'blood collection tube, 15 ml, Purple top (EDTA)', 'tube_blood collection_Purple_15ml', 'tube_blood collection_Purple_15ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9140, NULL, NULL, NULL, NULL, 'blood collection tube, 15 ml,Yellow top (sodium citrate)', 'tube_blood collection_Yellow_15ml', 'tube_blood collection_Yellow_15ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9141, NULL, NULL, NULL, NULL, 'blood collection tube, 15 ml, Green top (lithium heparin)', 'tube_blood collection_Green_15ml', 'tube_blood collection_Green_15ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9142, NULL, NULL, NULL, NULL, 'blood collection tube, 5 ml, Pearl white top (Polymer Gel/K2 EDTA) for protein studies', 'tube_blood collection_White_5ml', 'tube_blood collection_White_5ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9143, NULL, NULL, NULL, NULL, 'blood collection tube, 4 ml, Red top (separation polymer)', 'tube_blood collection_Red_4ml', 'tube_blood collection_Red_4ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9144, NULL, NULL, NULL, NULL, 'blood collection tube, 4 ml, Purple top (EDTA)', 'tube_blood collection_Purple_4ml', 'tube_blood collection_Purple_4ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9145, NULL, NULL, NULL, NULL, 'blood collection tube, 4 ml,Yellow top (sodium citrate)', 'tube_blood collection_Yellow_4ml', 'tube_blood collection_Yellow_4ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9146, NULL, NULL, NULL, NULL, 'blood collection tube, 4 ml, Green top (lithium heparin)', 'tube_blood collection_Green_4ml', 'tube_blood collection_Green_4ml', 'SIMPLE', NULL, 9050, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9147, NULL, NULL, NULL, NULL, 'glass capillary tube with maxVol=10 ul', 'tube_capillary_glass_10ul', 'tube_capillary_glass_10ul', 'SIMPLE', NULL, 9051, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9148, NULL, NULL, NULL, NULL, 'polycarbonate centrifuge tube with maxVol=50 ml', 'tube_centrifuge_polycarbonate_50ml', 'tube_centrifuge_polycarbonate_50ml', 'SIMPLE', NULL, 9052, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9149, NULL, NULL, NULL, NULL, 'polypropylene centrifuge tube with maxVol=50 ml', 'tube_centrifuge_polypropylene_50ml', 'tube_centrifuge_polypropylene_50ml', 'SIMPLE', NULL, 9052, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9150, NULL, NULL, NULL, NULL, 'polypropylene centrifuge tube with maxVol=15 ml', 'tube_centrifuge_polypropylene_15ml', 'tube_centrifuge_polypropylene_15ml', 'SIMPLE', NULL, 9052, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9151, NULL, NULL, NULL, NULL, 'flat top microtube with maxVol=200ul', 'tube_microtube_flatTop_200ul', 'tube_microtube_flatTop_200ul', 'SIMPLE', NULL, 9053, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9152, NULL, NULL, NULL, NULL, 'flat top microtube with maxVol=500ul', 'tube_microtube_flatTop_500ul', 'tube_microtube_flatTop_500ul', 'SIMPLE', NULL, 9053, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9153, NULL, NULL, NULL, NULL, 'flat top microtube with maxVol=1.5ml', 'tube_microtube_flatTop_1.5ml', 'tube_microtube_flatTop_1.5ml', 'SIMPLE', NULL, 9053, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9154, NULL, NULL, NULL, NULL, 'flat top microtube with maxVol=2ml', 'tube_microtube_flatTop_2ml', 'tube_microtube_flatTop_2ml', 'SIMPLE', NULL, 9053, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9155, NULL, NULL, NULL, NULL, 'Screw Top microtube with maxVol=200ul', 'tube_microtube_screwtop_200ul', 'tube_microtube_screwtop_200ul', 'SIMPLE', NULL, 9054, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9156, NULL, NULL, NULL, NULL, 'Screw Top microtube with maxVol=500ul', 'tube_microtube_screwtop_500ul', 'tube_microtube_screwtop_500ul', 'SIMPLE', NULL, 9054, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9157, NULL, NULL, NULL, NULL, 'Screw Top microtube with maxVol=1.5ml', 'tube_microtube_screwtop_1.5ml', 'tube_microtube_screwtop_1.5ml', 'SIMPLE', NULL, 9054, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9158, NULL, NULL, NULL, NULL, 'Screw Top microtube with maxVol=2ml', 'tube_microtube_screwtop_2ml', 'tube_microtube_screwtop_2ml', 'SIMPLE', NULL, 9054, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9161, NULL, NULL, NULL, NULL, 'tube, 200 ul maxV, flat-bottom, for optical scanning, clear', 'tube_optical_clear_200ul', 'tube_optical_clear_200ul', 'SIMPLE', NULL, 9056, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9162, NULL, NULL, NULL, NULL, 'tube, 200 ul maxV, flat-bottom, for optical scanning, white', 'tube_optical_white_200ul', 'tube_optical_white_200ul', 'SIMPLE', NULL, 9056, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9163, NULL, NULL, NULL, NULL, 'tube, 200 ul maxV, flat-bottom, for optical scanning, black', 'tube_optical_black_200ul', 'tube_optical_black_200ul', 'SIMPLE', NULL, 9056, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9164, NULL, NULL, NULL, NULL, 'polypropylene screwtop tube with maxVol=3 ml', 'tube_screwtop_polypropylene_3ml', 'tube_screwtop_polypropylene_3ml', 'SIMPLE', NULL, 9057, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9165, NULL, NULL, NULL, NULL, 'polypropylene screwtop tube with maxVol=10 ml', 'tube_screwtop_polypropylene_10ml', 'tube_screwtop_polypropylene_10ml', 'SIMPLE', NULL, 9057, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9166, NULL, NULL, NULL, NULL, 'polypropylene screwtop tube with maxVol=15 ml', 'tube_screwtop_polypropylene_15ml', 'tube_screwtop_polypropylene_15ml', 'SIMPLE', NULL, 9057, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9167, NULL, NULL, NULL, NULL, 'glass screwtop tube with maxVol=15 ml', 'tube_screwtop_glass_15ml', 'tube_screwtop_glass_15ml', 'SIMPLE', NULL, 9057, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9168, NULL, NULL, NULL, NULL, 'polypropylene screwtop tube with maxVol=50 ml', 'tube_screwtop_polypropylene_50ml', 'tube_screwtop_polypropylene_50ml', 'SIMPLE', NULL, 9057, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9169, NULL, NULL, NULL, NULL, 'polycarbonate ultracentrifuge tube with maxVol=3 ml', 'tube_ultracentrifuge_polycarbonate_3ml', 'tube_ultracentrifuge_polycarbonate_3ml', 'SIMPLE', NULL, 9058, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9170, NULL, NULL, NULL, NULL, 'polycarbonate ultracentrifuge tube with maxVol=1 ml', 'tube_ultracentrifuge_polycarbonate_1ml', 'tube_ultracentrifuge_polycarbonate_1ml', 'SIMPLE', NULL, 9058, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9159, NULL, NULL, NULL, NULL, 'polypropylene strip tube with 12 wells and with maxVol=200ul per well', 'tube_microtube_strip_12_200ul', 'tube_microtube_strip_12_200ul', 'SIMPLE', NULL, 9055, 100509);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9160, NULL, NULL, NULL, NULL, 'polypropylene strip tube with 8 wells and with maxVol=200ul per well', 'tube_microtube_strip_8_200ul', 'tube_microtube_strip_8_200ul', 'SIMPLE', NULL, 9055, 100515);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9069, NULL, NULL, NULL, NULL, '1x1, maxVol = 250 ml', 'bottle_screwtop__250ml', 'bottle_screwtop__250ml', 'SIMPLE', NULL, 9019, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9071, NULL, NULL, NULL, NULL, '1x1, maxVol = 500 ml', 'bottle_roller_screwTop_500ml', 'bottle_roller_screwTop_500ml', 'SIMPLE', NULL, 9020, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9064, NULL, NULL, NULL, NULL, '1x1, maxVol = 1 L', 'bottle_narrowMouth_screwTop_1L', 'bottle_narrowMouth_screwTop_1L', 'SIMPLE', NULL, 9017, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9128, NULL, NULL, NULL, NULL, 'shipping container: size 12x15 styrofoam for temperature control', 'shipping_styrofoam_tempControl_12x15', 'shipping_styrofoam_tempControl_12x15', 'COMPLEX', NULL, 9044, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199518, 'superuser1', '2010-10-22 14:42:27.19', '2010-10-22 17:53:44.911', 'superuser1', 'Visotube is part of the CBS Liquid N2 Freezer System.  A visotubes holds 12-14 straws.  There are 11 visotubes per Goblet and 6 Goblets per Goblet cannister/rack.', 'Visotube', 'Visotube', 'COMPLEX', 9133, 199517, NULL);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199511, 'superuser1', '2010-10-22 14:24:21.511', '2010-10-22 14:26:04.189', 'superuser1', 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 50 ul.', 'well_50ul', 'well_50ul', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199512, 'superuser1', '2010-10-22 14:26:39.317', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 100 ul.', 'well_100ul', 'well_100ul', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199513, 'superuser1', '2010-10-22 14:27:14.618', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 200 ul.', 'well_200ul', 'well_200ul', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199514, 'superuser1', '2010-10-22 14:28:01.799', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 0.5 ml.', 'well_0.5ml', 'well_0.5ml', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199515, 'superuser1', '2010-10-22 14:28:42.239', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 1.0 ml.', 'well_1.0ml', 'well_1.0ml', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199516, 'superuser1', '2010-10-22 14:29:14.721', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 2.0 ml.', 'well_2.0ml', 'well_2.0ml', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9099, NULL, NULL, '2010-10-29 14:06:39.825', 'adminuser', '384-well plate, 100 ul maxVol, V-bottom, for PCR instruments', 'plate_384-well_PCR_100ul', 'plate_384-well_PCR_100ul', 'COMPOSITE', 199512, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9105, NULL, NULL, '2010-10-29 14:08:52.862', 'adminuser', '384-well plate, 50 ul maxVol, flat-bottom, for optical scanning, black', 'plate_384-well_OpticalB_50ul', 'plate_384-well_OpticalB_50ul', 'COMPOSITE', 199511, 9035, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (9112, NULL, NULL, '2010-10-29 14:14:11.707', 'adminuser', '384-well plate, 50 ul maxVol, flat-bottom, for tissue culture with Poly-D-Lysine and Collagen I coatings', 'plate_cell culture_384W_50ul', 'plate_cell culture_384W_50ul', 'COMPOSITE', 199511, 9037, 100503);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199562, 'adminuser', '2010-10-29 14:20:50.586', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 500ul', 'well_500ul', 'well_500ul', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199563, 'adminuser', '2010-10-29 14:23:15.656', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 120 ul', 'well_120ul', 'well_120ul', 'SIMPLE', NULL, 199510, 100502);
INSERT INTO containertype (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, composition, containertype_fk, containersubcategory_fk, layout_fk) VALUES (199564, 'adminuser', '2010-10-29 14:24:35.746', NULL, NULL, 'A single ''well'' (in a container that cannot be physically separated from the parent container) - maxVol = 240 ul.', 'well_240ul', 'well_240ul', 'SIMPLE', NULL, 199510, 100502);


--
-- TOC entry 2956 (class 0 OID 3742031)
-- Dependencies: 1914 2949 2980
-- Data for Name: containertype_layout; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9091, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9129, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9086, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199516, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9166, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9089, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9087, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9141, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199515, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9097, 100511);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9170, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9085, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9149, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9061, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9094, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9131, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9060, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9132, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9153, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9165, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9152, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9151, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9136, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9168, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9154, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9150, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9142, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199514, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9169, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9066, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9068, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9140, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9127, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9162, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9117, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9122, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9159, 100509);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9130, 100512);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9160, 100515);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9114, 100513);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9125, 100514);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9126, 100510);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9121, 100510);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9118, 100506);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9124, 100506);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9115, 100506);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9119, 100506);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9123, 100506);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9116, 100516);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9076, 100507);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9073, 100507);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9064, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9167, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9088, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9134, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9137, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9113, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9157, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9071, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9144, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9145, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9096, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9070, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9147, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9133, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9161, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9077, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9158, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199512, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9148, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9065, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9135, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9093, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9156, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9084, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9155, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9067, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9128, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9163, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9095, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9138, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9078, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9069, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199511, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9079, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199513, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9146, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9164, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9092, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9090, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9063, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9139, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9082, 100504);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9075, 100504);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9074, 100508);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9072, 100508);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9083, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9143, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9099, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9102, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9101, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9105, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9103, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9104, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9109, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9110, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9107, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9106, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9111, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9112, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199562, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9108, 100501);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199563, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (199564, 100502);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9098, 100503);
INSERT INTO containertype_layout (containertype_id, layout_id) VALUES (9100, 100503);


--
-- TOC entry 2972 (class 0 OID 3742140)
-- Dependencies: 1930 2980 3020
-- Data for Name: fillpattern; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100517, 'adminuser', '2010-10-20 13:03:36.228', NULL, NULL, '12X8 FillPattern by Col: fill starting in C01R01  (= X01Y01) and proceeds by column: C1R2, C1R3,..', 'C1R1-C12R8-ByCol', 'C1R1-C12R8-ByCol', 100004, 100501);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100518, 'adminuser', '2010-10-20 13:11:35.651', '2010-10-20 13:11:50.966', 'adminuser', '10x10 FillPattern by Row: fill starting in C01R01  (= X01Y01) and proceeds by row: C02R01, C03R01,', 'C1R1-C10R10-ByRow', 'C1R1-C10R10-ByRow', 100004, 100508);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100520, 'adminuser', '2010-10-20 13:16:34.843', NULL, NULL, '4X1 Container has one row of 4 spaces and is filled starting ..', 'C1R1-C4R1-ByRow', 'C1R1-C4R1-ByRow', 100004, 100512);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100519, 'adminuser', '2010-10-20 13:13:43.674', '2010-10-20 13:18:13.556', 'adminuser', '2X1 Container has one row of 2 spaces and is filled starting in C1R1 (= X1Y1) ...', 'C1R1-C2R1-ByRow', 'C1R1-C2R1-ByRow', 100004, 100511);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100521, 'adminuser', '2010-10-20 13:19:06.125', NULL, NULL, '8X1 Container has one row of 8 spaces and is filled starting in C1R1  (= X1Y1) ', 'C1R1-C8R1-ByRow', 'C1R1-C8R1-ByRow', 100004, 100515);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100523, 'adminuser', '2010-10-20 13:41:59.824', NULL, NULL, '4 x 2 FillPattern by Row: fill starting in C1R1 (=X01Y01) and proceeds by row: C2R1, ...', 'C1R1-C4R2-ByRow', 'C1R1-C4R2-ByRow', 100004, 100513);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100524, 'adminuser', '2010-10-20 13:44:18.451', NULL, NULL, '4X2 FillPattern by Column: fill starting in C1R1  (= X01Y01) ', 'C1R1-C4R2-ByCol', 'C1R1-C4R2-ByCol', 100004, 100513);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100522, 'adminuser', '2010-10-20 13:36:16.683', '2010-10-20 13:46:34.949', 'adminuser', '12X1 Container has one row of 12 spaces and is filled starting in R01C01 and proceeds by row: C02R01', 'C1R1-C12R1-ByRow', 'C1R1-C12R1-ByRow', 100004, 100509);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100525, 'adminuser', '2010-10-20 13:47:49.13', NULL, NULL, '5X2 FillPattern by Row:  fill starting in C1R1 (= X01Y01) and proceeds by row: C2R1,', 'C1R1-C5R2-ByRow', 'C1R1-C5R2-ByRow', 100004, 100514);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100526, 'adminuser', '2010-10-20 13:49:06.977', NULL, NULL, '5X2 FillPattern by Column: fill starting in C1R1 (= X01Y01) and proceeds by column: C1R2,', 'C1R1-C5R2-ByCol', 'C1R1-C5R2-ByCol', 100004, 100514);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100527, 'adminuser', '2010-10-20 13:52:02.611', NULL, NULL, '6X4 FillPattern by Row: fill starting in C1R1  (= X01Y01) and proceeds by row: C2R1, ', 'C1R1-C6R4-ByRow', 'C1R1-C6R4-ByRow', 100004, 100506);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100528, 'adminuser', '2010-10-20 13:53:19.091', NULL, NULL, '6X4 FillPattern by Column: fill starting in C1R1  (= X01Y01) and proceeds by column: C1R2,', 'C1R1-C6R4ByCol', 'C1R1-C6R4ByCol', NULL, 100506);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100529, 'adminuser', '2010-10-20 13:56:14.311', NULL, NULL, '12X4 FillPattern by Row: fill starting in C01R01  (= X01Y01) and proceeds by row: C02R01,', 'C1R1-C12R4-ByRow', 'C1R1-C12R4-ByRow', 100004, 100510);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100530, 'adminuser', '2010-10-20 13:59:31.102', NULL, NULL, '12X4 FillPattern by Col: fill starting in C1R1  (= X01Y01) and proceeds by column: C1R2, ', 'C1R1-C12R4-ByCol', 'C1R1-C12R4-ByCol', NULL, 100510);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100531, 'adminuser', '2010-10-20 14:10:09.777', NULL, NULL, '10X1 Container has one row of 10 spaces and is filled starting in C1R1 and proceeds by row: C02R01', 'C1R1-C10R1-ByRow', 'C1R1-C10R1-ByRow', NULL, 100504);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100541, 'superuser1', '2010-10-21 20:41:59.684', NULL, NULL, 'Random distribution of samples leaving blank wells for controls.', '12x8RandomPlusControls', '12x8RandomPlusControls', 100003, 100501);
INSERT INTO fillpattern (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, person_fk, layout_fk) VALUES (100505, 'adminuser', '2010-10-20 12:17:52.862', '2010-10-22 16:53:49.334', 'superuser1', ' 12X8 FillPattern by Row: fill starting in C01R01  (= X01Y01) and proceeds by row: R01C02, R01C03, .', 'C1R1-C12R8-ByRow', 'C1R1-C12R8-ByRow', 100004, 100501);


--
-- TOC entry 2951 (class 0 OID 3742000)
-- Dependencies: 1909 2972
-- Data for Name: coordinate_fillpattern; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 1, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 2, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 3, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 4, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 5, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 6, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 0, 7, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 2, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 3, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 4, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 5, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 6, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 1, 7, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 0, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 1, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 2, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 3, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 4, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 5, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 6, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 2, 7, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 0, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 1, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 2, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 3, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 4, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 5, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 6, 30);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 3, 7, 31);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 0, 32);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 1, 33);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 2, 34);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 3, 35);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 4, 36);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 5, 37);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 6, 38);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 4, 7, 39);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 0, 40);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 1, 41);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 2, 42);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 3, 43);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 4, 44);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 5, 45);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 6, 46);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 5, 7, 47);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 0, 48);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 1, 49);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 2, 50);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 3, 51);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 4, 52);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 5, 53);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 6, 54);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 6, 7, 55);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 0, 56);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 1, 57);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 2, 58);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 3, 59);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 4, 60);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 5, 61);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 6, 62);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 7, 7, 63);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 0, 64);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 1, 65);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 2, 66);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 3, 67);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 4, 68);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 5, 69);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 6, 70);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 8, 7, 71);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 0, 72);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 1, 73);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 2, 74);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 3, 75);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 4, 76);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 5, 77);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 6, 78);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 9, 7, 79);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 0, 80);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 1, 81);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 2, 82);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 3, 83);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 4, 84);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 5, 85);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 6, 86);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 10, 7, 87);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 0, 88);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 1, 89);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 2, 90);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 3, 91);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 4, 92);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 5, 93);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 6, 94);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100517, 11, 7, 95);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 0, 1, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 1, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 2, 1, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100524, 3, 1, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 6, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 7, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 8, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 9, 0, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 10, 0, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100522, 11, 0, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 0, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 0, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 1, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 1, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 1, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 1, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 1, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 1, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 1, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 1, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 1, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 1, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 2, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 2, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 2, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 2, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 2, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 2, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 2, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 2, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 2, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 2, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 3, 30);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 3, 31);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 3, 32);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 3, 33);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 3, 34);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 3, 35);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 3, 36);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 3, 37);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 3, 38);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 3, 39);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 4, 40);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 4, 41);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 4, 42);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 4, 43);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 4, 44);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 4, 45);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 4, 46);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 4, 47);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 1, 1, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 2, 1, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 3, 1, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100525, 4, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 0, 1, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 1, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 1, 1, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 2, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 2, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 3, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 3, 1, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 4, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100526, 4, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 0, 1, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 1, 1, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 2, 1, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 3, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 4, 1, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 5, 1, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 0, 2, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 1, 2, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 2, 2, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 3, 2, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 4, 2, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 5, 2, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 0, 3, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 1, 3, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 2, 3, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 3, 3, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 4, 3, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100527, 5, 3, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 0, 1, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 0, 2, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 0, 3, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 1, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 1, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 1, 2, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 1, 3, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 2, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 2, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 2, 2, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 2, 3, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 3, 0, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 3, 1, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 3, 2, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 3, 3, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 4, 0, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 4, 1, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 4, 2, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 4, 3, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 5, 0, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 5, 1, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 5, 2, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100528, 5, 3, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 6, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 7, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 8, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100531, 9, 0, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 4, 48);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 4, 49);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 5, 50);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 5, 51);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 5, 52);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 5, 53);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 5, 54);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 5, 55);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 5, 56);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 5, 57);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 5, 58);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 5, 59);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 6, 60);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 6, 61);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 6, 62);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 6, 63);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 6, 64);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 6, 65);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 6, 66);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 6, 67);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 6, 68);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 6, 69);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 7, 70);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 7, 71);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 7, 72);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 7, 73);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 7, 74);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 7, 75);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 7, 76);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 7, 77);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 7, 78);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 7, 79);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 8, 80);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 8, 81);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 8, 82);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 8, 83);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 8, 84);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 8, 85);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 8, 86);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 8, 87);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 8, 88);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 8, 89);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 0, 9, 90);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 1, 9, 91);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 2, 9, 92);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 3, 9, 93);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 4, 9, 94);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 5, 9, 95);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 6, 9, 96);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 7, 9, 97);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 8, 9, 98);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100518, 9, 9, 99);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 1, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 2, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100520, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100520, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100520, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100520, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100519, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100519, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 6, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100521, 7, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 2, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 3, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 0, 1, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 1, 1, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 2, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100523, 3, 1, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 3, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 4, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 5, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 6, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 7, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 8, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 9, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 10, 0, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 11, 0, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 1, 1, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 2, 1, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 3, 1, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 4, 1, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 5, 1, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 6, 1, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 7, 1, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 8, 1, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 9, 1, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 10, 1, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 11, 1, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 1, 2, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 2, 2, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 3, 2, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 4, 2, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 5, 2, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 6, 2, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 7, 2, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 8, 2, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 9, 2, 30);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 10, 2, 31);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 11, 2, 32);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 1, 3, 33);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 2, 3, 34);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 3, 3, 35);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 4, 3, 36);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 5, 3, 37);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 6, 3, 38);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 7, 3, 39);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 8, 3, 40);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 9, 3, 41);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 10, 3, 42);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100529, 11, 3, 43);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 2, 1, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 2, 2, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 2, 3, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 3, 1, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 3, 2, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 3, 3, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 4, 1, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 4, 2, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 4, 3, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 5, 1, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 5, 2, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 5, 3, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 6, 1, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 6, 2, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 6, 3, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 7, 1, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 7, 2, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 7, 3, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 8, 1, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 8, 2, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 8, 3, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 9, 1, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 9, 2, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 9, 3, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 10, 1, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 10, 2, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 10, 3, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 11, 1, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 11, 2, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100530, 11, 3, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 1, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 1, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 2, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 2, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 3, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 4, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 5, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 6, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 7, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 0, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 1, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 2, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 3, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 4, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 5, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 5, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 6, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 6, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 6, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 6, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 6, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 7, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 7, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 0, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 0, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 1, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 2, 30);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 3, 31);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 4, 32);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 5, 33);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 7, 34);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 1, 35);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 2, 36);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 3, 37);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 4, 38);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 5, 39);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 6, 40);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 7, 41);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 7, 42);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 0, 43);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 0, 44);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 1, 45);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 1, 46);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 1, 47);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 2, 48);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 2, 49);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 3, 50);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 4, 51);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 5, 52);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 5, 53);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 7, 54);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 7, 55);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 7, 56);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 4, 57);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 3, 58);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 11, 1, 59);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 2, 60);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 0, 3, 61);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 4, 62);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 3, 63);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 4, 64);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 6, 65);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 7, 66);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 7, 67);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 2, 68);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 1, 6, 69);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 5, 70);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 2, 3, 71);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 1, 72);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 5, 2, 73);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 4, 74);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 4, 5, 75);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 0, 76);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 6, 4, 77);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 7, 0, 78);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 5, 79);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 9, 6, 80);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 10, 4, 81);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 3, 0, 82);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100541, 8, 3, 83);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 0, 0);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 0, 1);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 0, 2);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 0, 3);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 0, 4);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 0, 5);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 0, 6);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 0, 7);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 0, 8);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 0, 9);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 0, 10);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 0, 11);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 1, 12);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 1, 13);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 1, 14);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 1, 15);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 1, 16);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 1, 17);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 1, 18);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 1, 19);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 1, 20);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 1, 21);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 1, 22);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 1, 23);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 2, 24);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 2, 25);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 2, 26);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 2, 27);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 2, 28);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 2, 29);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 2, 30);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 2, 31);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 2, 32);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 2, 33);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 2, 34);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 2, 35);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 3, 36);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 3, 37);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 3, 38);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 3, 39);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 3, 40);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 3, 41);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 3, 42);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 3, 43);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 3, 44);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 3, 45);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 3, 46);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 4, 47);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 4, 48);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 4, 49);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 4, 50);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 4, 51);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 4, 52);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 4, 53);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 4, 54);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 4, 55);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 4, 56);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 4, 57);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 4, 58);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 5, 59);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 5, 60);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 5, 61);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 5, 62);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 5, 63);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 5, 64);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 5, 65);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 5, 66);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 5, 67);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 5, 68);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 5, 69);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 5, 70);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 6, 71);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 6, 72);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 6, 73);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 6, 74);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 6, 75);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 6, 76);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 6, 77);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 6, 78);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 6, 79);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 6, 80);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 6, 81);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 6, 82);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 11, 7, 83);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 0, 7, 84);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 1, 7, 85);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 2, 7, 86);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 3, 7, 87);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 4, 7, 88);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 5, 7, 89);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 6, 7, 90);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 7, 7, 91);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 8, 7, 92);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 9, 7, 93);
INSERT INTO coordinate_fillpattern (id_coordinate_fillpattern, x, y, list_index) VALUES (100505, 10, 7, 94);


--
-- TOC entry 2917 (class 0 OID 3741589)
-- Dependencies: 1861
-- Data for Name: csm_application; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_application (application_id, application_name, application_description, update_date, database_url, database_user_name, database_password, database_dialect, database_driver, declarative_flag, active_flag, csm_version) VALUES (1, 'csmupt', 'CSM UPT Super Admin Application', '2010-10-21', NULL, NULL, NULL, NULL, NULL, '0', '0', NULL);
INSERT INTO csm_application (application_id, application_name, application_description, update_date, database_url, database_user_name, database_password, database_dialect, database_driver, declarative_flag, active_flag, csm_version) VALUES (2, 'calims2', 'calims2 Application Description', '2010-10-21', 'jdbc:postgresql://localhost:5432/csmupt1', 'dbadmin', 'eLbzKYqoPYI=', 'org.hibernate.dialect.PostgreSQLDialect', 'org.postgresql.Driver', '1', '1', '42');


--
-- TOC entry 2919 (class 0 OID 3741624)
-- Dependencies: 1865
-- Data for Name: csm_filter_clause; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2920 (class 0 OID 3741636)
-- Dependencies: 1867 2917
-- Data for Name: csm_group; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (1, 'SuperUser', 'SuperUser', '2010-10-21', 2);
INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (2, 'Labmanager', 'Labmanager', '2010-10-21', 2);
INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (3, 'PI', 'PI', '2010-10-21', 2);
INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (4, 'Lab Researcher', 'Lab Researcher', '2010-10-21', 2);
INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (5, 'Guest', 'Guest', '2010-10-21', 2);
INSERT INTO csm_group (group_id, group_name, group_desc, update_date, application_id) VALUES (6, 'Customer', 'Customer', '2010-10-21', 2);


--
-- TOC entry 2918 (class 0 OID 3741603)
-- Dependencies: 1863 2917
-- Data for Name: csm_mapping; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2922 (class 0 OID 3741654)
-- Dependencies: 1871 2917
-- Data for Name: csm_protection_element; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (1, 'csmupt', 'CSM UPT Super Admin Application Protection Element', 'csmupt', NULL, NULL, NULL, 1, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (2, 'calims2', 'calims2 Admin Application Protection Element', 'calims2', NULL, NULL, NULL, 1, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (3, 'ROLE_USER', 'ROLE_USER for hello world', 'ROLE_USER', NULL, NULL, NULL, 2, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (4, 'ROLE_ADMIN', 'ROLE_ADMIN for hello world', 'ROLE_ADMIN', NULL, NULL, NULL, 2, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (5, 'ROLE_CUSTOMER_REQUEST', 'PE for customer requests', 'ROLE_CUSTOMER_REQUEST', NULL, NULL, NULL, 2, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (6, 'ROLE_CUSTOMER_REQUEST_CUSTOMER', 'Pe for customers of CRs', 'ROLE_CUSTOMER_REQUEST_CUSTOMER', NULL, NULL, NULL, 2, '2010-10-21');
INSERT INTO csm_protection_element (protection_element_id, protection_element_name, protection_element_description, object_id, attribute, attribute_value, protection_element_type, application_id, update_date) VALUES (7, 'ROLE_CUSTOMER_REQUEST_MANAGER', 'Pe for managers of CRs', 'ROLE_CUSTOMER_REQUEST_MANAGER', NULL, NULL, NULL, 2, '2010-10-21');


--
-- TOC entry 2923 (class 0 OID 3741666)
-- Dependencies: 1873 2917
-- Data for Name: csm_protection_group; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_protection_group (protection_group_id, protection_group_name, protection_group_description, application_id, large_element_count_flag, update_date, parent_protection_group_id) VALUES (1, 'ROLE_USER PG', 'ROLE_USER PG', 2, 0, '2010-10-21', NULL);
INSERT INTO csm_protection_group (protection_group_id, protection_group_name, protection_group_description, application_id, large_element_count_flag, update_date, parent_protection_group_id) VALUES (2, 'ROLE_ADMIN PG', 'ROLE_ADMIN PG', 2, 0, '2010-10-21', NULL);
INSERT INTO csm_protection_group (protection_group_id, protection_group_name, protection_group_description, application_id, large_element_count_flag, update_date, parent_protection_group_id) VALUES (3, 'ROLE_CUSTOMER_REQUEST PG', 'ROLE_CUSTOMER_REQUEST PG', 2, 0, '2010-10-21', NULL);
INSERT INTO csm_protection_group (protection_group_id, protection_group_name, protection_group_description, application_id, large_element_count_flag, update_date, parent_protection_group_id) VALUES (4, 'ROLE_CUSTOMER_REQUEST_CUSTOMER PG', 'ROLE_CUSTOMER_REQUEST_CUSTOMER PG', 2, 0, '2010-10-21', NULL);
INSERT INTO csm_protection_group (protection_group_id, protection_group_name, protection_group_description, application_id, large_element_count_flag, update_date, parent_protection_group_id) VALUES (5, 'ROLE_CUSTOMER_REQUEST_MANAGER PG', 'ROLE_CUSTOMER_REQUEST_MANAGER PG', 2, 0, '2010-10-21', NULL);


--
-- TOC entry 2924 (class 0 OID 3741675)
-- Dependencies: 1875 2922 2923
-- Data for Name: csm_pg_pe; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_pg_pe (pg_pe_id, protection_group_id, protection_element_id, update_date) VALUES (1, 1, 3, '2010-10-21');
INSERT INTO csm_pg_pe (pg_pe_id, protection_group_id, protection_element_id, update_date) VALUES (2, 2, 4, '2010-10-21');
INSERT INTO csm_pg_pe (pg_pe_id, protection_group_id, protection_element_id, update_date) VALUES (3, 3, 5, '2010-10-21');
INSERT INTO csm_pg_pe (pg_pe_id, protection_group_id, protection_element_id, update_date) VALUES (4, 4, 6, '2010-10-21');
INSERT INTO csm_pg_pe (pg_pe_id, protection_group_id, protection_element_id, update_date) VALUES (5, 5, 7, '2010-10-21');


--
-- TOC entry 2921 (class 0 OID 3741645)
-- Dependencies: 1869
-- Data for Name: csm_privilege; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (1, 'CREATE', 'This privilege grants permission to a user to create an entity. This entity can be an object, a database entry, or a resource such as a network connection', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (2, 'ACCESS', 'This privilege allows a user to access a particular resource.  Examples of resources include a network or database connection, socket, module of the application, or even the application itself', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (3, 'READ', 'This privilege permits the user to read data from a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to read data about a particular entry', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (4, 'WRITE', 'This privilege allows a user to write data to a file, URL, database, an object, etc. This can be used at an entity level signifying that the user is allowed to write data about a particular entity', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (5, 'UPDATE', 'This privilege grants permission at an entity level and signifies that the user is allowed to update data for a particular entity. Entities may include an object, object attribute, database row etc', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (6, 'DELETE', 'This privilege permits a user to delete a logical entity. This entity can be an object, a database entry, a resource such as a network connection, etc', '2010-10-21');
INSERT INTO csm_privilege (privilege_id, privilege_name, privilege_description, update_date) VALUES (7, 'EXECUTE', 'This privilege allows a user to execute a particular resource. The resource can be a method, function, behavior of the application, URL, button etc', '2010-10-21');


--
-- TOC entry 2925 (class 0 OID 3741684)
-- Dependencies: 1877 2917
-- Data for Name: csm_role; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_role (role_id, role_name, role_description, application_id, active_flag, update_date) VALUES (1, 'ROLE_ACCESS', 'ACCESS ONLY ROLE', 2, 1, '2010-10-21');
INSERT INTO csm_role (role_id, role_name, role_description, application_id, active_flag, update_date) VALUES (2, 'ROLE_CREATE', 'CREATE ONLY ROLE', 2, 1, '2010-10-21');
INSERT INTO csm_role (role_id, role_name, role_description, application_id, active_flag, update_date) VALUES (3, 'ROLE_UPDATE', 'UPDATE ONLY ROLE', 2, 1, '2010-10-21');
INSERT INTO csm_role (role_id, role_name, role_description, application_id, active_flag, update_date) VALUES (4, 'ROLE_DELETE', 'DELETE ONLY ROLE', 2, 1, '2010-10-21');


--
-- TOC entry 2926 (class 0 OID 3741693)
-- Dependencies: 1879 2921 2925
-- Data for Name: csm_role_privilege; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_role_privilege (role_privilege_id, role_id, privilege_id) VALUES (1, 1, 2);
INSERT INTO csm_role_privilege (role_privilege_id, role_id, privilege_id) VALUES (2, 2, 1);
INSERT INTO csm_role_privilege (role_privilege_id, role_id, privilege_id) VALUES (3, 3, 5);
INSERT INTO csm_role_privilege (role_privilege_id, role_id, privilege_id) VALUES (4, 4, 6);


--
-- TOC entry 2927 (class 0 OID 3741701)
-- Dependencies: 1881
-- Data for Name: csm_user; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (1, NULL, 0, 'superadmin', '<<super_admin_first_name>>', '<<super_admin_last_name>>', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (2, NULL, 0, 'calims2admin', 'visee', 'michael', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (3, NULL, 0, 'superuser1', 'Super', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (4, NULL, 0, 'labmanager1', 'Lab Manager', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (5, NULL, 0, 'pi1', 'PI', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (6, NULL, 0, 'labresearcher1', 'researcher', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (7, NULL, 0, 'guest1', 'guest', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (8, NULL, 0, 'customer1', 'customer1', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (9, NULL, 0, 'customer2', 'customer2', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (10, NULL, 0, 'adminuser', 'Admin', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');
INSERT INTO csm_user (user_id, premgrt_login_name, migrated_flag, login_name, first_name, last_name, organization, department, title, phone_number, password, email_id, start_date, end_date, update_date) VALUES (11, NULL, 0, 'user03', 'No', 'User', NULL, NULL, NULL, NULL, 'zJPWCwDeSgG8j2uyHEABIQ==', NULL, NULL, NULL, '2010-10-21');


--
-- TOC entry 2928 (class 0 OID 3741714)
-- Dependencies: 1883 2927 2920
-- Data for Name: csm_user_group; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (1, 3, 1);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (2, 4, 2);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (3, 5, 3);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (4, 6, 4);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (5, 7, 5);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (6, 8, 6);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (7, 9, 6);
INSERT INTO csm_user_group (user_group_id, user_id, group_id) VALUES (8, 10, 1);


--
-- TOC entry 2929 (class 0 OID 3741722)
-- Dependencies: 1885 2920 2925 2923 2927
-- Data for Name: csm_user_group_role_pg; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (1, NULL, 1, 1, 1, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (2, NULL, 1, 1, 2, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (3, NULL, 1, 1, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (4, NULL, 1, 2, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (5, NULL, 1, 3, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (6, NULL, 1, 4, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (7, NULL, 1, 1, 4, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (8, NULL, 1, 1, 5, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (9, NULL, 2, 1, 1, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (10, NULL, 2, 1, 2, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (11, NULL, 2, 1, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (12, NULL, 2, 2, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (13, NULL, 2, 3, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (14, NULL, 2, 4, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (15, NULL, 2, 1, 5, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (16, NULL, 5, 1, 1, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (17, NULL, 6, 1, 1, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (18, NULL, 6, 1, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (19, NULL, 6, 2, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (20, NULL, 6, 3, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (21, NULL, 6, 4, 3, '2010-10-21');
INSERT INTO csm_user_group_role_pg (user_group_role_pg_id, user_id, group_id, role_id, protection_group_id, update_date) VALUES (22, NULL, 6, 1, 4, '2010-10-21');


--
-- TOC entry 2930 (class 0 OID 3741731)
-- Dependencies: 1887 2927 2922
-- Data for Name: csm_user_pe; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO csm_user_pe (user_protection_element_id, protection_element_id, user_id) VALUES (1, 1, 1);
INSERT INTO csm_user_pe (user_protection_element_id, protection_element_id, user_id) VALUES (2, 2, 2);


--
-- TOC entry 2957 (class 0 OID 3742036)
-- Dependencies: 1915 2952 3037
-- Data for Name: customerrequest_service; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199532, 100190);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199532, 100194);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199532, 100191);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199533, 100194);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199533, 100190);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199533, 100191);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199534, 100190);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199534, 100194);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199534, 100191);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199531, 100191);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199531, 100190);
INSERT INTO customerrequest_service (customerrequest_id, service_id) VALUES (199531, 100194);


--
-- TOC entry 2963 (class 0 OID 3742077)
-- Dependencies: 1921 3057 2967
-- Data for Name: environmentalcondition; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2964 (class 0 OID 3742085)
-- Dependencies: 1922 2960 2974
-- Data for Name: equipment_hazard; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2965 (class 0 OID 3742090)
-- Dependencies: 1923 3017 2960
-- Data for Name: equipment_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100145, 100001);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100213, 100001);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100215, 100001);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100217, 100001);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100529, 100163);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100530, 100163);
INSERT INTO equipment_organization (equipment_id, organization_id) VALUES (100531, 100163);


--
-- TOC entry 2966 (class 0 OID 3742095)
-- Dependencies: 1924 2960 3020
-- Data for Name: equipment_person; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO equipment_person (equipment_id, person_id) VALUES (100145, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100213, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100215, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100217, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100529, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100530, 100004);
INSERT INTO equipment_person (equipment_id, person_id) VALUES (100531, 100004);


--
-- TOC entry 2962 (class 0 OID 3742070)
-- Dependencies: 1920 3036 2961
-- Data for Name: externalidentifier_sequen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2973 (class 0 OID 3742148)
-- Dependencies: 1931 2941
-- Data for Name: fluidspecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO fluidspecimen (preparation, id) VALUES ('centrifugation', 100630);


--
-- TOC entry 2975 (class 0 OID 3742161)
-- Dependencies: 1933 3057 2952
-- Data for Name: inquiry; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2977 (class 0 OID 3742174)
-- Dependencies: 1935 3017 2976
-- Data for Name: invoice_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO invoice_organization (invoice_id, organization_id) VALUES (100188, 100163);


--
-- TOC entry 2984 (class 0 OID 3742224)
-- Dependencies: 1942 3017 2978
-- Data for Name: laboratory_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO laboratory_organization (laboratory_id, organization_id) VALUES (100180, 100175);
INSERT INTO laboratory_organization (laboratory_id, organization_id) VALUES (100182, 100175);
INSERT INTO laboratory_organization (laboratory_id, organization_id) VALUES (100178, 100165);
INSERT INTO laboratory_organization (laboratory_id, organization_id) VALUES (100183, 100163);
INSERT INTO laboratory_organization (laboratory_id, organization_id) VALUES (100131, 100001);


--
-- TOC entry 2985 (class 0 OID 3742229)
-- Dependencies: 1943 2978 3020
-- Data for Name: laboratory_person; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO laboratory_person (laboratory_id, person_id) VALUES (100180, 100004);
INSERT INTO laboratory_person (laboratory_id, person_id) VALUES (100182, 100004);
INSERT INTO laboratory_person (laboratory_id, person_id) VALUES (100178, 100004);
INSERT INTO laboratory_person (laboratory_id, person_id) VALUES (100183, 100004);
INSERT INTO laboratory_person (laboratory_id, person_id) VALUES (100131, 100004);


--
-- TOC entry 2983 (class 0 OID 3742219)
-- Dependencies: 1941 3017 2979
-- Data for Name: labsupply_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO labsupply_organization (labsupply_id, organization_id) VALUES (100554, 100163);
INSERT INTO labsupply_organization (labsupply_id, organization_id) VALUES (100555, 100163);
INSERT INTO labsupply_organization (labsupply_id, organization_id) VALUES (100556, 100163);


--
-- TOC entry 2986 (class 0 OID 3742234)
-- Dependencies: 1944 2949 2980
-- Data for Name: layout_containertype; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2981 (class 0 OID 3742203)
-- Dependencies: 1939 2987
-- Data for Name: lipid; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO lipid (category, chemicalformula, deltaxnomenclature, function, nxnomenclature, saturation, id) VALUES ('', 'CH3(CH2)4CH=CHCH2CH=CH(CH2)7COOH', 'cis,cis-{delta}9,{delta}12', '', 'n-6', 'unsaturated', 100633);


--
-- TOC entry 2989 (class 0 OID 3742252)
-- Dependencies: 1947 2937 2944
-- Data for Name: nanomaterial; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO nanomaterial (id, chemicalcompound_fk) VALUES (100640, NULL);


--
-- TOC entry 2990 (class 0 OID 3742257)
-- Dependencies: 1948 2931
-- Data for Name: notes_account; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2991 (class 0 OID 3742260)
-- Dependencies: 1949 2932
-- Data for Name: notes_accountnumber; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2992 (class 0 OID 3742263)
-- Dependencies: 1950 2933
-- Data for Name: notes_adapter; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2993 (class 0 OID 3742266)
-- Dependencies: 1951 2934
-- Data for Name: notes_additionalorganismn; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2994 (class 0 OID 3742269)
-- Dependencies: 1952 2939
-- Data for Name: notes_billinginformation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2995 (class 0 OID 3742272)
-- Dependencies: 1953 2953
-- Data for Name: notes_characteristics; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2996 (class 0 OID 3742275)
-- Dependencies: 1954 2946
-- Data for Name: notes_contactinformation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2997 (class 0 OID 3742278)
-- Dependencies: 1955 2952
-- Data for Name: notes_customerrequest; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2998 (class 0 OID 3742281)
-- Dependencies: 1956 2967
-- Data for Name: notes_event; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 2999 (class 0 OID 3742284)
-- Dependencies: 1957 2974
-- Data for Name: notes_hazard; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3000 (class 0 OID 3742287)
-- Dependencies: 1958 2976
-- Data for Name: notes_invoice; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3001 (class 0 OID 3742290)
-- Dependencies: 1959 2979
-- Data for Name: notes_labsupply; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3002 (class 0 OID 3742293)
-- Dependencies: 1960 2980
-- Data for Name: notes_layout; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3040 (class 0 OID 3742484)
-- Dependencies: 1998 3057 2960
-- Data for Name: software; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO software (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, numberofusers, operatingsystem, serialnumber, status, version, type_fk, equipment_fk) VALUES (100206, 'superuser1', '2010-08-24 00:05:17.194', '2010-08-24 00:10:48.044', 'superuser1', 'Software for the operation of the Affymetrix Fluidics Station and GeneChip Scanner and for analysis', 'AGCC software', 'Affymetrix Genotyping Console', '2011-09-29 00:00:00', 5, 'Window XP', 'SN12345', 'DEFAULT', '1', 100054, NULL);
INSERT INTO software (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, numberofusers, operatingsystem, serialnumber, status, version, type_fk, equipment_fk) VALUES (100207, 'superuser1', '2010-08-24 00:07:05.683', NULL, NULL, 'Affymetrix software for Gene Expression collection and analysis', 'Affymetrix GCOS', 'Affymetrix GCOS', '2011-08-31 00:00:00', 5, 'Windows XP', 'SN23456', 'DEFAULT', '3.3', 100053, 100215);
INSERT INTO software (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, expirationdate, numberofusers, operatingsystem, serialnumber, status, version, type_fk, equipment_fk) VALUES (100216, 'superuser1', '2010-08-24 15:37:42.081', NULL, NULL, 'This is the controling software for the Applied Biosystems Automated Sequencers.', 'ABDCv 3.0', 'Applied Biosystems Data Collection version 3.0', '2011-12-30 00:00:00', NULL, 'Windows XP', 'SN293949', 'DEFAULT', '3.0', 100053, 100217);


--
-- TOC entry 3018 (class 0 OID 3742348)
-- Dependencies: 1976 3057 3042 3040
-- Data for Name: parameter; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3003 (class 0 OID 3742296)
-- Dependencies: 1961 3018
-- Data for Name: notes_parameter; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3021 (class 0 OID 3742369)
-- Dependencies: 1979 3057 2946
-- Data for Name: postaladdress; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO postaladdress (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, addressstreetpostdirectionalt, addressstreetpredirectionalty, city, country, county, firstaddressline, mailstopcode, postofficeboxnumber, postalcode, secondaddressline, state, status, contactinformation_fk, type_fk) VALUES (100141, 'superuser1', '2010-08-21 18:10:43.573', NULL, NULL, '', 'postal address', 'Test Org postal address', '', '', 'Rockville', '', '', '11 oneone street', '', '', '20850', '', 'MS', 'DEFAULT', 100139, 100044);
INSERT INTO postaladdress (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, addressstreetpostdirectionalt, addressstreetpredirectionalty, city, country, county, firstaddressline, mailstopcode, postofficeboxnumber, postalcode, secondaddressline, state, status, contactinformation_fk, type_fk) VALUES (100150, 'superuser1', '2010-08-21 19:35:01.831', NULL, NULL, '', 'postal1', 'test postal 1', '', '', 'Rockville', 'US', '', '11 one st', '', '', '20850', '', 'MD', 'DEFAULT', 100148, 100044);
INSERT INTO postaladdress (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, addressstreetpostdirectionalt, addressstreetpredirectionalty, city, country, county, firstaddressline, mailstopcode, postofficeboxnumber, postalcode, secondaddressline, state, status, contactinformation_fk, type_fk) VALUES (100169, 'labmanager1', '2010-08-23 16:48:58.414', NULL, NULL, 'The main postal address for NIH>', 'NIH Main Address', 'NIH Main Postal Address', '', '', 'Bethesda', 'USA', '', '9000 Rockville Lane', '', '', '20892', '', 'MD', 'DEFAULT', 100168, 100044);
INSERT INTO postaladdress (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, addressstreetpostdirectionalt, addressstreetpredirectionalty, city, country, county, firstaddressline, mailstopcode, postofficeboxnumber, postalcode, secondaddressline, state, status, contactinformation_fk, type_fk) VALUES (100172, 'labmanager1', '2010-08-23 16:59:03.925', NULL, NULL, 'The main US postal address for NCI.', 'NCI Main Postal Address', 'NCI Main Postal Address', '', '', 'Bethesda', 'USA', '', '6116 Executive Boulevard', '', '', '20892-8322', 'NCI Office of Communications and Education, Suite 300', 'MD', 'DEFAULT', 100171, 100044);
INSERT INTO postaladdress (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, addressstreetpostdirectionalt, addressstreetpredirectionalty, city, country, county, firstaddressline, mailstopcode, postofficeboxnumber, postalcode, secondaddressline, state, status, contactinformation_fk, type_fk) VALUES (100186, 'superuser1', '2010-08-23 18:22:38.786', '2010-09-12 20:43:50.419', 'superuser1', '', 'PO Box 123', 'Official mail box', '', '', 'Rockville', '', '', '123 Fourth St', '', 'PO BOX 123', '20854', '', 'MD', 'DEFAULT', 100184, 100044);


--
-- TOC entry 3004 (class 0 OID 3742299)
-- Dependencies: 1962 3021
-- Data for Name: notes_postaladdress; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3005 (class 0 OID 3742302)
-- Dependencies: 1963 3031
-- Data for Name: notes_quotation; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3006 (class 0 OID 3742305)
-- Dependencies: 1964 3032
-- Data for Name: notes_rate; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3034 (class 0 OID 3742439)
-- Dependencies: 1992 3020 2978 3017
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100012, 'superuser1', '2010-08-20 02:07:48.629', '2010-08-20 02:15:08.452', 'superuser1', 'An enterprise or an entity that produces finished goods.', 'Manufacturer', 'Manufacturer', 'ACTIVE', 1, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100019, 'superuser1', '2010-08-20 02:37:50.782', NULL, NULL, 'Part  of scientific organization that spans institutions.', 'Consortium member', 'Consortium member', 'ACTIVE', 3, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100020, 'superuser1', '2010-08-20 02:42:26.876', NULL, NULL, 'Member of  a group of two or more parties work jointly towards a common goal.', 'Collaboration member', 'Collaboration member', 'ACTIVE', 3, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100022, 'superuser1', '2010-08-20 02:52:14.532', NULL, NULL, 'Individual who is responsible for managing interactions with customers (e.g. accounts and billing).', 'Business Manager', 'Business Manager', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100023, 'superuser1', '2010-08-20 02:56:32.201', NULL, NULL, 'The PI responsible for the direction and supervision of a Laboratory within NIH.', 'Lab Chief', 'Laboratory Branch Chief', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100025, 'superuser1', '2010-08-20 03:03:14.87', NULL, NULL, 'One of two or more scientists working together on a research project.', 'CO-PI', 'Co-Investigator', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100029, 'superuser1', '2010-08-20 03:12:09.423', NULL, NULL, 'A person who works on information technology as applied to the life sciences.', 'Bioinformatician', 'Bioinformatician', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100028, 'superuser1', '2010-08-20 03:10:04.874', NULL, NULL, 'Person responsible for maintaining and ordering the Laboratory supplies and reagents.', 'Inventory Manager', 'Inventory Manager', 'ACTIVE', 0, 100004, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100030, 'superuser1', '2010-08-20 03:19:16.44', NULL, NULL, 'Individual who designs and performs experiments.  A Staff Scientist is generally supervised by a PI.', 'SS', 'Staff Scientist', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100032, 'superuser1', '2010-08-20 03:22:45.04', NULL, NULL, 'One who is enrolled in an educational institution working toward a degree beyond baccalaureate.', 'Grad Student', 'Graduate Student', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100033, 'superuser1', '2010-08-20 03:26:26.787', NULL, NULL, 'Individual who performs the quality control functions.', 'QC Manager', 'Quality Control Manager', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100034, 'superuser1', '2010-08-20 03:28:40.525', NULL, NULL, 'Someone who instructs others in the use of, for example, equipment or techniques.', 'Trainer', 'Trainer', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100036, 'superuser1', '2010-08-20 03:35:44.494', NULL, NULL, 'Sysadmins are usually charged with installing, supporting, and maintaining servers/other computers.', 'SysAdmin', 'Systems Administrator', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100037, 'superuser1', '2010-08-20 03:38:24.04', NULL, NULL, 'Individual responsible for maintaining the Lab Safety regulations and documentation.', 'SO', 'Safety Officer', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100179, 'labmanager1', '2010-08-23 17:41:55.691', NULL, NULL, 'Design and execution of algorithms to acertain data quality.', 'Data QC', 'Data Quality Control', 'ACTIVE', 3, NULL, NULL, 100180);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100021, 'superuser1', '2010-08-20 02:49:19.737', '2010-08-21 18:17:22.334', 'superuser1', 'A person who facilitates scientific research through various efforts - expenditures, budgets, etc.', 'Administrator', 'Administrator', 'ACTIVE', 0, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100181, 'labmanager1', '2010-08-23 17:45:01.389', NULL, NULL, 'Laboratory that performs wet lab experiments.', 'Basic Research', 'Basic Research', 'ACTIVE', 3, NULL, NULL, 100182);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100017, 'superuser1', '2010-08-20 02:21:16.96', NULL, NULL, 'A group with the power or right to give orders or make decisions for a particular area of activity.', 'Regulatory Authority', 'Regulatory Authority', 'ACTIVE', 1, NULL, 100173, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100035, 'superuser1', '2010-08-20 03:30:38.409', NULL, NULL, 'A person acting as a channel for communication between groups or on behalf of a group.', 'Contact Person', 'Contact Person', 'ACTIVE', 0, 100009, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100011, 'superuser1', '2010-08-18 20:27:33.986', '2010-08-20 03:15:58.972', 'superuser1', 'Individual who does sample preparation, runs experiments/assays, records results/observations.', 'Research Technician', 'Research Laboratory Technician', 'ACTIVE', 0, 100006, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100016, 'superuser1', '2010-08-20 02:18:33.474', NULL, NULL, 'An organization founded and united for a specific purpose.', 'Institution', 'Institution', 'ACTIVE', 1, NULL, 100165, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100013, 'superuser1', '2010-08-20 02:10:01.841', NULL, NULL, 'An organization that purchases items or service.', 'Customer', 'Customer', 'ACTIVE', 1, NULL, 100165, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100026, 'superuser1', '2010-08-20 03:05:19.12', NULL, NULL, 'Lab Manager/Core Director responsible for organization, training, and running of Laboratory.', 'Lab Manager', 'Laboratory Manager', 'ACTIVE', 0, 100008, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100015, 'superuser1', '2010-08-20 02:13:16.728', NULL, NULL, 'An agency that promotes or exchanges goods or services for money.', 'Vendor', 'Vendor', 'ACTIVE', 1, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100014, 'superuser1', '2010-08-20 02:11:26.509', '2010-08-20 02:16:18.011', 'superuser1', 'An organization that underwrites financial support for projects of a particular type.', 'Funder', 'Funding Organization', 'ACTIVE', 1, NULL, 100223, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100031, 'superuser1', '2010-08-20 03:20:52.096', NULL, NULL, 'Individual with a doctoral degree who designs and performs experiments.', 'PostDoc', 'Post Doctoral Student', 'ACTIVE', 0, 100007, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100154, 'superuser1', '2010-08-23 14:52:53.851', NULL, NULL, 'An organization engaged in research.', 'Research Organization', 'Research Organization', 'ACTIVE', 1, NULL, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100027, 'superuser1', '2010-08-20 03:07:28.222', NULL, NULL, 'Lab Manager/Core Director responsible for organization, training, and running of Laboratory.', 'CF Director', 'Core Facility Director', 'ACTIVE', 0, 100004, NULL, NULL);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100018, 'superuser1', '2010-08-20 02:27:16.121', NULL, NULL, 'An entity that provides services and/or products for biomedical research on a fee for service basis.', 'Core Facility', 'Core Facility', 'ACTIVE', 3, NULL, NULL, 100183);
INSERT INTO role (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, status, type, person_fk, organization_fk, laboratory_fk) VALUES (100024, 'superuser1', '2010-08-20 03:01:21.531', NULL, NULL, 'The scientist or scholar with primary responsibility for the design/conduct of a research project.', 'PI', 'Principal Investigator', 'ACTIVE', 0, NULL, NULL, NULL);


--
-- TOC entry 3007 (class 0 OID 3742308)
-- Dependencies: 1965 3034
-- Data for Name: notes_role; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3035 (class 0 OID 3742447)
-- Dependencies: 1993 2974
-- Data for Name: safetycaution; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3008 (class 0 OID 3742311)
-- Dependencies: 1966 3035
-- Data for Name: notes_safetycaution; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3009 (class 0 OID 3742314)
-- Dependencies: 1967 3037
-- Data for Name: notes_service; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3038 (class 0 OID 3742471)
-- Dependencies: 1996 3057 3032 2976 2939 3031 3037
-- Data for Name: serviceitem; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO serviceitem (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, enddate, quantity, startdate, status, billinginformation_fk, quotation_fk, service_fk, rate_fk, type_fk, invoice_fk) VALUES (199561, 'superuser1', '2010-10-27 20:16:01.856', NULL, NULL, 'ServiceItem for Consultation on Array Method/Assay Design.', 'SI-ConsultationArrayAssayDesign', 'SI-ConsultationArrayAssayDesign', NULL, 3, NULL, 'DEFAULT', NULL, NULL, 100197, 199560, 199539, NULL);


--
-- TOC entry 3010 (class 0 OID 3742317)
-- Dependencies: 1968 3038
-- Data for Name: notes_serviceitem; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3011 (class 0 OID 3742320)
-- Dependencies: 1969 3040
-- Data for Name: notes_software; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3041 (class 0 OID 3742492)
-- Dependencies: 1999 3057 2958 3020
-- Data for Name: sop; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3012 (class 0 OID 3742323)
-- Dependencies: 1970 3041
-- Data for Name: notes_sop; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3013 (class 0 OID 3742326)
-- Dependencies: 1971 3042
-- Data for Name: notes_specimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3046 (class 0 OID 3742526)
-- Dependencies: 2004 3057 3054
-- Data for Name: strain; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3014 (class 0 OID 3742329)
-- Dependencies: 1972 3046
-- Data for Name: notes_strain; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3015 (class 0 OID 3742332)
-- Dependencies: 1973 3054
-- Data for Name: notes_taxon; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3022 (class 0 OID 3742377)
-- Dependencies: 1980 3016
-- Data for Name: primer; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO primer (id) VALUES (100634);
INSERT INTO primer (id) VALUES (100635);


--
-- TOC entry 3019 (class 0 OID 3742356)
-- Dependencies: 1977 3016 3022 3022
-- Data for Name: pcrproduct; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO pcrproduct (expectedsize, observedsize, id, forwardprimer_fk, reverseprimer_fk) VALUES (NULL, NULL, 100636, 100634, 100635);


--
-- TOC entry 3024 (class 0 OID 3742387)
-- Dependencies: 1982 3017 3020
-- Data for Name: person_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO person_organization (person_id, organization_id) VALUES (100004, 100001);
INSERT INTO person_organization (person_id, organization_id) VALUES (100006, 100163);
INSERT INTO person_organization (person_id, organization_id) VALUES (100007, 100001);
INSERT INTO person_organization (person_id, organization_id) VALUES (100003, 100001);
INSERT INTO person_organization (person_id, organization_id) VALUES (100009, 100165);
INSERT INTO person_organization (person_id, organization_id) VALUES (100008, 100001);


--
-- TOC entry 3025 (class 0 OID 3742392)
-- Dependencies: 1983 2967 3057 3043
-- Data for Name: quantity_centrifugationev; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3026 (class 0 OID 3742395)
-- Dependencies: 1984 3057 2947 3043
-- Data for Name: quantity_container; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100542, 100623, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100542, 100623, 1, '500');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100542, 100623, 3, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100543, 100623, 3, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100543, 100623, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100543, 100623, 1, '1000');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100545, 100623, 3, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100545, 100623, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100545, 100623, 1, '0.5');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100546, 100624, 1, '300');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100546, 100624, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100546, 100624, 3, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (199528, 100624, 2, '1000');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (199528, 100623, 3, '1');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (199528, 100622, 1, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100549, 100623, 1, '1.47');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100549, 100623, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100549, 100623, 3, '0.03');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100547, 100623, 3, '0.3');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100547, 100623, 1, '2.8');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100547, 100623, 2, '0');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (199519, NULL, 1, '24');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100548, 100623, 1, '1.47');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100548, 100623, 3, '0.3');
INSERT INTO quantity_container (id_quantity_container, standardunit_fk, type_fk, value) VALUES (100548, 100623, 2, '0');


--
-- TOC entry 3027 (class 0 OID 3742398)
-- Dependencies: 1985 3057 2963 3043
-- Data for Name: quantity_environmentalcon; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3028 (class 0 OID 3742401)
-- Dependencies: 1986 3057 2979 3043
-- Data for Name: quantity_labsupply; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100555, NULL, 9002, '0');
INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100555, NULL, 9001, '15');
INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100555, NULL, 9003, '15');
INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100556, NULL, 9003, '50');
INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100556, NULL, 9002, '4');
INSERT INTO quantity_labsupply (id_quantity_labsupply, standardunit_fk, type_fk, value) VALUES (100556, NULL, 9001, '50');


--
-- TOC entry 3029 (class 0 OID 3742404)
-- Dependencies: 1987 3042 3057 3043
-- Data for Name: quantity_specimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100634, 100624, 1001, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100634, 100624, 1003, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100634, 100624, 1004, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100634, 100624, 1002, '0');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100635, 100624, 1001, '164');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100635, 100624, 1003, '164');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100635, 100624, 1004, '175');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100635, 100624, 1002, '0');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100637, 100624, 1003, '570');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100637, 100624, 1001, '520');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100637, 100624, 1004, '870');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100637, 100624, 1002, '50');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100639, 100623, 1003, '1');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100639, 100623, 1002, '0');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100639, 100623, 1004, '1.5');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100639, 100623, 1001, '1');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100636, 100624, 1001, '25');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100636, 100624, 1003, '25');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100636, 100624, 1004, '37');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100636, 100624, 1002, '0');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100631, 100624, 1002, '10');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100631, 100624, 1004, '500');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100631, 100624, 1003, '200');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100631, 100624, 1001, '210');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100633, 100624, 1001, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100633, 100624, 1004, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100633, 100624, 1002, '0');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100633, 100624, 1003, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100626, 100624, 1002, '25');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100626, 100624, 1003, '100');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100626, 100624, 1001, '125');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100626, 100624, 1004, '250');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100630, 100623, 1003, '4.8');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100630, 100623, 1001, '4.8');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100630, 100623, 1004, '5');
INSERT INTO quantity_specimen (id_quantity_specimen, standardunit_fk, type_fk, value) VALUES (100630, 100623, 1002, '0');


--
-- TOC entry 3033 (class 0 OID 3742431)
-- Dependencies: 1991 2976 2931
-- Data for Name: report; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3030 (class 0 OID 3742407)
-- Dependencies: 1988 3057 3033
-- Data for Name: query; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3048 (class 0 OID 3742542)
-- Dependencies: 2006 2958 3035
-- Data for Name: safetycaution_document; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3049 (class 0 OID 3742547)
-- Dependencies: 2007 3020 3035
-- Data for Name: safetycaution_person; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3051 (class 0 OID 3742557)
-- Dependencies: 2009 3037 2952
-- Data for Name: service_customerrequest; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3050 (class 0 OID 3742552)
-- Dependencies: 2008 3038 2932
-- Data for Name: serviceitem_accountnumber; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3039 (class 0 OID 3742479)
-- Dependencies: 1997 2987
-- Data for Name: smallmolecule; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO smallmolecule (chemicalformula, mechanismofaction, id) VALUES ('C27H29NO11', 'DNA intercalation', 100639);


--
-- TOC entry 3052 (class 0 OID 3742562)
-- Dependencies: 2010 3017 3042
-- Data for Name: specimen_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100630, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100634, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100635, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100636, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100637, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100633, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100629, 100175);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100631, 100163);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100640, 100165);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100552, 100163);
INSERT INTO specimen_organization (specimen_id, organization_id) VALUES (100626, 100175);


--
-- TOC entry 3053 (class 0 OID 3742567)
-- Dependencies: 2011 3045 3017
-- Data for Name: storagespace_organization; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100211, 100001);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100212, 100001);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100209, 100001);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100539, 100163);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100535, 100163);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100536, 100163);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100537, 100163);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100538, 100163);
INSERT INTO storagespace_organization (storagespace_id, organization_id) VALUES (100540, 100163);


--
-- TOC entry 3047 (class 0 OID 3742534)
-- Dependencies: 2005 3057 3030
-- Data for Name: summary; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3055 (class 0 OID 3742580)
-- Dependencies: 2013 3057 2946
-- Data for Name: telephonenumber; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO telephonenumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, rank, status, telephonenumberextension, value, contactinformation_fk, type_fk) VALUES (100140, 'superuser1', '2010-08-21 18:06:29.67', NULL, NULL, '', 'Desk Number', 'Org contact Desk number', '1', 'DEFAULT', '2211', '1212213333', 100139, 100047);
INSERT INTO telephonenumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, rank, status, telephonenumberextension, value, contactinformation_fk, type_fk) VALUES (100149, 'superuser1', '2010-08-21 19:33:46.048', NULL, NULL, '', 'desk #', 'test desk number', '1', 'DEFAULT', '', '11111111', 100148, 100047);
INSERT INTO telephonenumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, rank, status, telephonenumberextension, value, contactinformation_fk, type_fk) VALUES (100170, 'labmanager1', '2010-08-23 16:50:28.197', NULL, NULL, 'The main phone number for NIH', 'NIH Main Phone Number', 'NIH Main Phone Number', '1', 'DEFAULT', '', '3014964000', 100168, 100047);
INSERT INTO telephonenumber (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, rank, status, telephonenumberextension, value, contactinformation_fk, type_fk) VALUES (100185, 'superuser1', '2010-08-23 18:20:39.984', NULL, NULL, '', 'desk number', 'Official desk number', '1', 'DEFAULT', '', '2402343344', 100184, 100047);


--
-- TOC entry 3056 (class 0 OID 3742588)
-- Dependencies: 2014 2941
-- Data for Name: tissuespecimen; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO tissuespecimen (preparation, id) VALUES ('flash frozen', 100637);


--
-- TOC entry 3058 (class 0 OID 3742601)
-- Dependencies: 2016 2959
-- Data for Name: uniformresourceidentifier; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



--
-- TOC entry 3061 (class 0 OID 3742622)
-- Dependencies: 2019 2988
-- Data for Name: word; Type: TABLE DATA; Schema: public; Owner: dbadmin
--

INSERT INTO word (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, characterset, delimiter, isincremented, maximumlength, minimumlength, padcharacter, rank, status, namingconvention_fk) VALUES (10002, 'adminuser', '2010-08-17 13:02:25.467', NULL, NULL, '', 'w1', 'w1', 1, '_', NULL, 3, 3, '', 1, 'DEFAULT', 10001);
INSERT INTO word (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, characterset, delimiter, isincremented, maximumlength, minimumlength, padcharacter, rank, status, namingconvention_fk) VALUES (10003, 'adminuser', '2010-08-17 13:03:00.915', NULL, NULL, '', 'w2', 'w2', 3, '', NULL, 3, 3, '0', 2, 'CURRENT', 10001);
INSERT INTO word (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, characterset, delimiter, isincremented, maximumlength, minimumlength, padcharacter, rank, status, namingconvention_fk) VALUES (100222, 'superuser1', '2010-08-24 16:00:25.86', '2010-08-24 16:00:49.866', 'superuser1', 'This is the ''word'' used to indicate repeats. EX: r1', 'Repeat Word 1', 'Repeat Word 1', 2, '', NULL, 2, 2, '', 3, 'APPROVALPENDING', 100218);
INSERT INTO word (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, characterset, delimiter, isincremented, maximumlength, minimumlength, padcharacter, rank, status, namingconvention_fk) VALUES (100221, 'superuser1', '2010-08-24 15:58:12.222', '2010-08-24 16:01:22.204', 'superuser1', 'This is the 4 digit Plate number with a ''0'' pad character. EX: 0022_', 'Plate Number 1', 'Plate Number Word 1', 3, '_', NULL, 4, 4, '0', 2, 'APPROVALPENDING', 100218);
INSERT INTO word (id, createdby, datecreated, datemodified, modifiedby, description, displayname, name, characterset, delimiter, isincremented, maximumlength, minimumlength, padcharacter, rank, status, namingconvention_fk) VALUES (100220, 'superuser1', '2010-08-24 15:55:53.723', '2010-08-24 16:01:52.219', 'superuser1', 'This ''word'' holds the designated Project Name information. EX: ZZ_', 'Project Name 1', 'Project Name Word 1', 2, '_', NULL, 2, 2, '', 1, 'APPROVALPENDING', 100218);


--
-- TOC entry 3062 (class 0 OID 3742630)
-- Dependencies: 2020 2979 3041
-- Data for Name: worksheet; Type: TABLE DATA; Schema: public; Owner: dbadmin
--



-- Completed on 2010-10-29 14:36:52 EDT

--
-- PostgreSQL database dump complete
--
    alter table ACCOUNT 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ACCOUNT 
        add constraint ACCOUNLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table ACCOUNT 
        add constraint ACCOUNORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table ACCOUNTNUMBER 
        add constraint ACCOUNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ACCOUNTNUMBER 
        add constraint ACCOUNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table ADAPTER 
        add constraint ADAPTETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ADAPTER 
        add constraint ADAPTER_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table ADAPTER 
        add constraint ADAPTER_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table ADAPTER 
        add constraint ADAPTER_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table ADDITIONALORGANISMNAME 
        add constraint ADDITITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ADDITIONALORGANISMNAME 
        add constraint ADDITIWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM;

    alter table ANTIBODY 
        add constraint FK_ANTIBODY_PROTEIN 
        foreign key (ID) 
        references PROTEIN;

    alter table ANTIBODY 
        add constraint ANTIBODY_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    create index ANTIGENUSE_USE_IDX on ANTIGEN (USE);

    alter table ANTIGEN 
        add constraint ANTIGETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ANTIGEN 
        add constraint ANTIGEN_SPECIMEN_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table ARTIFICIALSPECIMEN 
        add constraint FK_ARTIFICIALSPECIMEN_SPECIM 
        foreign key (ID) 
        references SPECIMEN;

    alter table BASEUNIT 
        add constraint FK_BASEUNIT_UNIT 
        foreign key (ID) 
        references UNIT;

    alter table BILLINGINFORMATION 
        add constraint BILLINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table BILLINGINFORMATION 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table BILLINGINFORMATION 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table BIOHAZARD 
        add constraint FK_BIOHAZARD_HAZARD 
        foreign key (ID) 
        references HAZARD;

    alter table BIOSPECIMEN 
        add constraint BIOSPETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table BIOSPECIMEN 
        add constraint FK_BIOSPECIMEN_SPECIMEN 
        foreign key (ID) 
        references SPECIMEN;

    alter table BIOSPECIMEN 
        add constraint BIOSPETAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON;

    alter table CARBOHYDRATE 
        add constraint FK_CARBOHYDRATE_MOLECULARSPE 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table CELLSPECIMEN 
        add constraint FK_CELLSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table CELLSPECIMEN 
        add constraint CELLSPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CHEMICALCOMPOUND 
        add constraint CHEMCIALCOM_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CHEMICALCOMPOUND 
        add constraint CHEMICALCOM_NANOMATERIAL_FK 
        foreign key (NANOMATERIAL_FK) 
        references NANOMATERIAL;

    alter table COLLABORATION 
        add constraint COLLABTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table COLLABORATION 
        add constraint COLLABROLE_FK 
        foreign key (ROLE_FK) 
        references ROLE;

    alter table CONTACTINFORMATION 
        add constraint CONTACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CONTACTINFORMATION 
        add constraint CONTACLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table CONTACTINFORMATION 
        add constraint CONTACCOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table CONTACTINFORMATION 
        add constraint CONTACPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table CONTACTINFORMATION 
        add constraint CONTACLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table CONTACTINFORMATION 
        add constraint CONTACORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table CONTAINER 
        add constraint CONTAILOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table CONTAINER 
        add constraint CONTAIFILLPA_FK 
        foreign key (FILLPATTERN_FK) 
        references FILLPATTERN;

    alter table CONTAINER 
        add constraint CONTAILAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table CONTAINER 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE;

    alter table CONTAINER 
        add constraint CHILDCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table CONTAINERSUBCATEGORY 
        add constraint CONTAITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CONTAINERTYPE 
        add constraint RELATELAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table CONTAINERTYPE 
        add constraint _CONTAINERTY_FK 
        foreign key (CONTAINERTYPE_FK) 
        references CONTAINERTYPE;

    alter table CONTAINERTYPE 
        add constraint CONTAICONTAI_FK 
        foreign key (CONTAINERSUBCATEGORY_FK) 
        references CONTAINERSUBCATEGORY;

    alter table COORDINATE_FILLPATTERN 
        add constraint FK_COORDINATE_FILLPATTERN 
        foreign key (ID_COORDINATE_FILLPATTERN) 
        references FILLPATTERN;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMERREQ_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table CUSTOMERREQUEST 
        add constraint CUSTOMERREQ_ACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table Characteristics 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table Characteristics 
        add constraint CHARACTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table Characteristics 
        add constraint BODYRECOATCO_FK 
        foreign key (COATCOLOR_FK) 
        references Characteristics;

    alter table Characteristics 
        add constraint PHYSICNUCLEI_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID;

    alter table Characteristics 
        add constraint CHEMICSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE;

    alter table Characteristics 
        add constraint CHARACSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table Characteristics 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table Characteristics 
        add constraint BIOCHAANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table Characteristics 
        add constraint FAMILYHISTO_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table Characteristics 
        add constraint PHYSICCHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table Collaboration_Laboratory 
        add constraint LABORATORY_COLLABORATIO_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Collaboration_Laboratory 
        add constraint COLLABORATIO_LABORATORY_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION;

    alter table Collaboration_Person 
        add constraint PERSON_COLLABORATIO_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table Collaboration_Person 
        add constraint COLLABORATIO_PERSON_ID 
        foreign key (COLLABORATION_ID) 
        references COLLABORATION;

    alter table ContainerType_Layout 
        add constraint CONTAINERTYP_LAYOUT_ID 
        foreign key (CONTAINERTYPE_ID) 
        references CONTAINERTYPE;

    alter table ContainerType_Layout 
        add constraint LAYOUT_CONTAINERTYP_ID 
        foreign key (LAYOUT_ID) 
        references LAYOUT;

    alter table CustomerRequest_Service 
        add constraint CUSTOMERREQU_SERVICE_ID 
        foreign key (CUSTOMERREQUEST_ID) 
        references CUSTOMERREQUEST;

    alter table CustomerRequest_Service 
        add constraint SERVICE_CUSTOMERREQU_ID 
        foreign key (SERVICE_ID) 
        references SERVICE;

    alter table DOCUMENT 
        add constraint DOCUMELOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table DOCUMENT 
        add constraint REFERESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table DOCUMENT 
        add constraint DOCUMEINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE;

    alter table DOCUMENT 
        add constraint DOCUMENAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION;

    alter table DOCUMENT 
        add constraint DOCUMECOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table DOCUMENT 
        add constraint DOCUMEEVENT_FK 
        foreign key (EVENT_FK) 
        references Event;

    alter table DOCUMENT 
        add constraint DOCUMEWORKSH_FK 
        foreign key (WORKSHEET_FK) 
        references WORKSHEET;

    alter table DOCUMENT 
        add constraint DOCUMEPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table DOCUMENT 
        add constraint REFERENCE_CHARACTERIS_FK 
        foreign key (CHARACTERISTICS_FK) 
        references Characteristics;

    alter table DOCUMENT 
        add constraint DOCUMEORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table DOCUMENT 
        add constraint DOCUMENT_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table DOCUMENT 
        add constraint DOCUMESERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE;

    alter table DOCUMENT 
        add constraint REFRENCE_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD;

    alter table DOCUMENT 
        add constraint DOCUMEEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table DOCUMENT 
        add constraint DOCUMECONTRA_FK 
        foreign key (CONTRACT_FK) 
        references CONTRACT;

    alter table DOCUMENT 
        add constraint DOCUMEQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION;

    alter table DOCUMENT 
        add constraint DOCUMEACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table DOCUMENT 
        add constraint DOCUMELABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table DOCUMENT 
        add constraint PROTOCOL_BIOSPECIMEN_FK 
        foreign key (BIOSPECIMEN_FK) 
        references BIOSPECIMEN;

    alter table DOCUMENT 
        add constraint DOCUMECHEMIC_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table DOCUMENT 
        add constraint REFERENCE_UNIT_FK 
        foreign key (UNIT_FK) 
        references UNIT;

    alter table DOCUMENT 
        add constraint DOCUMECUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table ELECTRONICDOCUMENT 
        add constraint MANUALEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table ELECTRONICDOCUMENT 
        add constraint FK_ELECTRONICDOCUMENT_DOCUME 
        foreign key (ID) 
        references DOCUMENT;

    alter table ELECTRONICDOCUMENT 
        add constraint MANUALSTORAG_FK 
        foreign key (STORAGESPACE_FK) 
        references STORAGESPACE;

    alter table ELECTRONICDOCUMENT 
        add constraint FILE_FILEFORMATS_FK 
        foreign key (FILEFORMATSPECIFICATION_FK) 
        references FILEFORMATSPECIFICATION;

    alter table EQUIPMENT 
        add constraint EQUIPMTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EQUIPMENT 
        add constraint EQUIPMENT_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table EQUIPMENT 
        add constraint EQUIPMLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNSEQUEN_FK 
        foreign key (SEQUENCE_FK) 
        references SEQUENCE;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNALIDE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table EXTERNALIDENTIFIER 
        add constraint EXTERNCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table EXTERNALIDENTIFIER_SEQUEN 
        add constraint FK_EXTERNALIDENTIFIER__SE 
        foreign key (ID_EXTERNALIDENTIFIER_SEQ) 
        references SEQUENCE;

    alter table EXTERNALIDENTIFIER_SEQUEN 
        add constraint FK445D0B0A6943998D 
        foreign key (externalIdentifierCollection_id) 
        references EXTERNALIDENTIFIER;

    alter table EnvironmentalCondition 
        add constraint ENVIROTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table EnvironmentalCondition 
        add constraint ENVIROEVENT_FK 
        foreign key (EVENT_FK) 
        references Event;

    alter table Equipment_Hazard 
        add constraint EQUIPMENT_HAZARD_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Hazard 
        add constraint HAZARD_EQUIPMENT_ID 
        foreign key (HAZARD_ID) 
        references HAZARD;

    alter table Equipment_Organization 
        add constraint ORGANIZATION_EQUIPMENT_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Equipment_Organization 
        add constraint EQUIPMENT_ORGANIZATION_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Person 
        add constraint EQUIPMENT_PERSON_ID 
        foreign key (EQUIPMENT_ID) 
        references EQUIPMENT;

    alter table Equipment_Person 
        add constraint PERSON_EQUIPMENT_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table Event 
        add constraint EVENTCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table Event 
        add constraint EVENTCLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table Event 
        add constraint EVENTCSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table Event 
        add constraint EVENTCWHOLEO_FK 
        foreign key (WHOLEORGANISM_FK) 
        references WHOLEORGANISM;

    alter table Event 
        add constraint EVENTCPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table Event 
        add constraint EVENTCCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table Event 
        add constraint EVENTCLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table Event 
        add constraint EVENTCORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table FEATURE 
        add constraint FEATURTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FEATURE 
        add constraint FEATURSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table FEATURE 
        add constraint EPITOPANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table FEATURE 
        add constraint FEATURSEQUEN_FK 
        foreign key (FEATURECOLLECTION_FK) 
        references SEQUENCE;

    alter table FILEEXTENSION 
        add constraint FILEEXTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FILEEXTENSION 
        add constraint FILEEXTENSI_ELECTRONICD_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFOFILETR_FK 
        foreign key (FILETRANSPORTER_FK) 
        references FILETRANSPORTER;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFORMATS_FILEEXTENSI_FK 
        foreign key (FILEEXTENSION_FK) 
        references FILEEXTENSION;

    alter table FILEFORMATSPECIFICATION 
        add constraint FILEFORMATS_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table FILLPATTERN 
        add constraint FILLPALAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table FILLPATTERN 
        add constraint FILLPATTERN_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table FLUIDSPECIMEN 
        add constraint FK_FLUIDSPECIMEN_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table HAZARD 
        add constraint HAZARDTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table HAZARD 
        add constraint HAZARDSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table HAZARD 
        add constraint HAZARD_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table HAZARD 
        add constraint HAZARDLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table INQUIRY 
        add constraint INQUIRTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table INQUIRY 
        add constraint FK_INQUIRY_CUSTOMERREQUEST 
        foreign key (ID) 
        references CUSTOMERREQUEST;

    alter table INVOICE 
        add constraint INVOICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table INVOICE 
        add constraint INVOICCUSTOM_FK 
        foreign key (CUSTOMERREQUEST_FK) 
        references CUSTOMERREQUEST;

    alter table Invoice_Organization 
        add constraint ORGANIZATION_INVOICE_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Invoice_Organization 
        add constraint INVOICE_ORGANIZATION_ID 
        foreign key (INVOICE_ID) 
        references INVOICE;

    alter table LABORATORY 
        add constraint LABORATORY_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table LABSUPPLY 
        add constraint LABSUPTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table LABSUPPLY 
        add constraint LABSUPCONTAI_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table LAYOUT 
        add constraint LAYOUT_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table LIPID 
        add constraint FK_LIPID_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table LOCATION 
        add constraint LOCATITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table LOCATION 
        add constraint CHILDLLOCATI_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table LOCATION 
        add constraint SAMPLISPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table LOCATION 
        add constraint LOCATITRAVEL_FK 
        foreign key (TRAVELHISTORY_FK) 
        references Characteristics;

    alter table LOCATION 
        add constraint INTERNSTORAG_FK 
        foreign key (STORAGESPACE_FK) 
        references STORAGESPACE;

    alter table LabSupply_Organization 
        add constraint ORGANIZATION_LABSUPPLY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table LabSupply_Organization 
        add constraint LABSUPPLY_ORGANIZATION_ID 
        foreign key (LABSUPPLY_ID) 
        references LABSUPPLY;

    alter table Laboratory_Organization 
        add constraint ORGANIZATION_LABORATORY_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Laboratory_Organization 
        add constraint LABORATORY_ORGANIZATION_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Laboratory_Person 
        add constraint LABORATORY_PERSON_ID 
        foreign key (LABORATORY_ID) 
        references LABORATORY;

    alter table Laboratory_Person 
        add constraint PERSON_LABORATORY_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table MOLECULARSPECIMEN 
        add constraint FK_MOLECULARSPECIMEN_BIOSPEC 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table NAMINGCONVENTION 
        add constraint NAMINGCONVE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table NAMINGCONVENTION 
        add constraint NAMINGLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table NANOMATERIAL 
        add constraint FK_NANOMATERIAL_ARTIFICIALSP 
        foreign key (ID) 
        references ARTIFICIALSPECIMEN;

    alter table NANOMATERIAL 
        add constraint NANOMATERIAL_CHEMICALCOM_FK 
        foreign key (CHEMICALCOMPOUND_FK) 
        references CHEMICALCOMPOUND;

    alter table NOTES_ACCOUNT 
        add constraint FK_NOTES__ACCOUNT 
        foreign key (ID_NOTES_ACCOUNT) 
        references ACCOUNT;

    alter table NOTES_ACCOUNTNUMBER 
        add constraint FK_NOTES__ACCOUNTNUMBER 
        foreign key (ID_NOTES_ACCOUNTNUMBER) 
        references ACCOUNTNUMBER;

    alter table NOTES_ADAPTER 
        add constraint FK_NOTES__ADAPTER 
        foreign key (ID_NOTES_ADAPTER) 
        references ADAPTER;

    alter table NOTES_ADDITIONALORGANISMN 
        add constraint FK_NOTES__ADDITIONALORGAN 
        foreign key (ID_NOTES_ADDITIONALORGANI) 
        references ADDITIONALORGANISMNAME;

    alter table NOTES_BILLINGINFORMATION 
        add constraint FK_NOTES__BILLINGINFORMAT 
        foreign key (ID_NOTES_BILLINGINFORMATI) 
        references BILLINGINFORMATION;

    alter table NOTES_CHARACTERISTICS 
        add constraint FK_NOTES__CHARACTERISTICS 
        foreign key (ID_NOTES_CHARACTERISTICS) 
        references Characteristics;

    alter table NOTES_CONTACTINFORMATION 
        add constraint FK_NOTES__CONTACTINFORMAT 
        foreign key (ID_NOTES_CONTACTINFORMATI) 
        references CONTACTINFORMATION;

    alter table NOTES_CUSTOMERREQUEST 
        add constraint FK_NOTES__CUSTOMERREQUEST 
        foreign key (ID_NOTES_CUSTOMERREQUEST) 
        references CUSTOMERREQUEST;

    alter table NOTES_EVENT 
        add constraint FK_NOTES__EVENT 
        foreign key (ID_NOTES_EVENT) 
        references Event;

    alter table NOTES_HAZARD 
        add constraint FK_NOTES__HAZARD 
        foreign key (ID_NOTES_HAZARD) 
        references HAZARD;

    alter table NOTES_INVOICE 
        add constraint FK_NOTES__INVOICE 
        foreign key (ID_NOTES_INVOICE) 
        references INVOICE;

    alter table NOTES_LABSUPPLY 
        add constraint FK_NOTES_LABSUPPLY 
        foreign key (ID_NOTES_LABSUPPLY) 
        references LABSUPPLY;

    alter table NOTES_LAYOUT 
        add constraint FK_NOTES_LAYOUT 
        foreign key (ID_NOTES_LAYOUT) 
        references LAYOUT;

    alter table NOTES_PARAMETER 
        add constraint FK_NOTES__PARAMETER 
        foreign key (ID_NOTES_PARAMETER) 
        references PARAMETER;

    alter table NOTES_POSTALADDRESS 
        add constraint FK_NOTES__POSTALADDRESS 
        foreign key (ID_NOTES_POSTALADDRESS) 
        references POSTALADDRESS;

    alter table NOTES_QUOTATION 
        add constraint FK_NOTES__QUOTATION 
        foreign key (ID_NOTES_QUOTATION) 
        references QUOTATION;

    alter table NOTES_RATE 
        add constraint FK_NOTES__RATE 
        foreign key (ID_NOTES_RATE) 
        references RATE;

    alter table NOTES_ROLE 
        add constraint FK_NOTES__ROLE 
        foreign key (ID_NOTES_ROLE) 
        references ROLE;

    alter table NOTES_SAFETYCAUTION 
        add constraint FK_NOTES__SAFETYCAUTION 
        foreign key (ID_NOTES_SAFETYCAUTION) 
        references SAFETYCAUTION;

    alter table NOTES_SERVICE 
        add constraint FK_NOTES__SERVICE 
        foreign key (ID_NOTES_SERVICE) 
        references SERVICE;

    alter table NOTES_SERVICEITEM 
        add constraint FK_NOTES__SERVICEITEM 
        foreign key (ID_NOTES_SERVICEITEM) 
        references SERVICEITEM;

    alter table NOTES_SOFTWARE 
        add constraint FK_NOTES__SOFTWARE 
        foreign key (ID_NOTES_SOFTWARE) 
        references SOFTWARE;

    alter table NOTES_SOP 
        add constraint FK_NOTES__SOP 
        foreign key (ID_NOTES_SOP) 
        references SOP;

    alter table NOTES_SPECIMEN 
        add constraint FK_NOTES__SPECIMEN 
        foreign key (ID_NOTES_SPECIMEN) 
        references SPECIMEN;

    alter table NOTES_STRAIN 
        add constraint FK_NOTES__STRAIN 
        foreign key (ID_NOTES_STRAIN) 
        references STRAIN;

    alter table NOTES_TAXON 
        add constraint FK_NOTES__TAXON 
        foreign key (ID_NOTES_TAXON) 
        references TAXON;

    alter table NUCLEICACID 
        add constraint FK_NUCLEICACID_MOLECULARSPEC 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table ORGANIZATION 
        add constraint ORGANITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table ORGANIZATION 
        add constraint ORGANIZATION_LOCATION_FK 
        foreign key (LOCATION_FK) 
        references LOCATION;

    alter table ORGANIZATION 
        add constraint ORGANICOLLAB_FK 
        foreign key (COLLABORATION_FK) 
        references COLLABORATION;

    alter table ORGANIZATION 
        add constraint CHILDOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table PARAMETER 
        add constraint PARAMETYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table PARAMETER 
        add constraint PARAMESPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table PARAMETER 
        add constraint PARAMESOFTWA_FK 
        foreign key (SOFTWARE_FK) 
        references SOFTWARE;

    alter table PCRPRODUCT 
        add constraint FK_PCRPRODUCT_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID;

    alter table PCRPRODUCT 
        add constraint PCRPRODUCTB_PRIMER_FK 
        foreign key (FORWARDPRIMER_FK) 
        references PRIMER;

    alter table PCRPRODUCT 
        add constraint PCRPRODUCTA_PRIMER_FK 
        foreign key (REVERSEPRIMER_FK) 
        references PRIMER;

    alter table PERSON 
        add constraint PERSON_EXTERNALIDE_FK 
        foreign key (EXTERNALIDENTIFIER_FK) 
        references EXTERNALIDENTIFIER;

    alter table PERSON 
        add constraint PERSONSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table PERSON 
        add constraint SERVICBILLIN_FK 
        foreign key (SERVICEITEMBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table PERSON 
        add constraint PERSONLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table PERSON 
        add constraint PERSONBILLIN_FK 
        foreign key (PERSONBILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table POSTALADDRESS 
        add constraint POSTALTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table POSTALADDRESS 
        add constraint POSTALCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION;

    alter table PRIMER 
        add constraint FK_PRIMER_NUCLEICACID 
        foreign key (ID) 
        references NUCLEICACID;

    alter table PROTEIN 
        add constraint FK_PROTEIN_MOLECULARSPECIMEN 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table Person_Organization 
        add constraint ORGANIZATION_PERSON_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Person_Organization 
        add constraint PERSON_ORGANIZATION_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint FK_QUANTITY__CENTRIFUGATI 
        foreign key (ID_QUANTITY_CENTRIFUGATIO) 
        references Event;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_CENTRIFUGATIONEV 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_CONTAINER 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_CONTAINER 
        add constraint FK_QUANTITY_CONTAINER 
        foreign key (ID_QUANTITY_CONTAINER) 
        references CONTAINER;

    alter table QUANTITY_CONTAINER 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint FK_QUANTITY__ENVIRONMENTA 
        foreign key (ID_QUANTITY_ENVIRONMENTAL) 
        references EnvironmentalCondition;

    alter table QUANTITY_ENVIRONMENTALCON 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_LABSUPPLY 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_LABSUPPLY 
        add constraint FK_QUANTITY_LABSUPPLY 
        foreign key (ID_QUANTITY_LABSUPPLY) 
        references LABSUPPLY;

    alter table QUANTITY_LABSUPPLY 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUANTITY_SPECIMEN 
        add constraint FK_QUANTITY__SPECIMEN 
        foreign key (ID_QUANTITY_SPECIMEN) 
        references SPECIMEN;

    alter table QUANTITY_SPECIMEN 
        add constraint QUANTITYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUANTITY_SPECIMEN 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table QUERY 
        add constraint QUERYCTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUERY 
        add constraint QUERYCREPORT_FK 
        foreign key (REPORT_FK) 
        references REPORT;

    alter table QUOTATION 
        add constraint QUOTATTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table QUOTATION 
        add constraint QUANTITYPE_FK 
        foreign key (QUANTITY_TYPE_FK) 
        references TYPE;

    alter table QUOTATION 
        add constraint QUOTATION_RATE_FK 
        foreign key (RATE_FK) 
        references RATE;

    alter table QUOTATION 
        add constraint QUANTITY_STANDARDUNIT_FK 
        foreign key (QUANTITY_STANDARDUNIT_FK) 
        references STANDARDUNIT;

    alter table RATE 
        add constraint RATECOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table RATE 
        add constraint RATE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table REPORT 
        add constraint REPORTINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE;

    alter table REPORT 
        add constraint REPORTACCOUNT_FK 
        foreign key (ACCOUNT_FK) 
        references ACCOUNT;

    alter table ROLE 
        add constraint ROLECOPERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table ROLE 
        add constraint ROLECOLABORA_FK 
        foreign key (LABORATORY_FK) 
        references LABORATORY;

    alter table ROLE 
        add constraint ROLECOORGANI_FK 
        foreign key (ORGANIZATION_FK) 
        references ORGANIZATION;

    alter table SAFETYCAUTION 
        add constraint SAFETYCAUTI_HAZARD_FK 
        foreign key (HAZARD_FK) 
        references HAZARD;

    alter table SEQUENCE 
        add constraint SEQUENCE_NUCLEICACID_FK 
        foreign key (NUCLEICACID_FK) 
        references NUCLEICACID;

    alter table SEQUENCE 
        add constraint SEQUENCEA_FEATURE_FK 
        foreign key (NTERMINUS_FK) 
        references FEATURE;

    alter table SEQUENCE 
        add constraint SEQUENCE_PHYSICALCHA_FK 
        foreign key (PHYSICALCHARACTERISTICS_FK) 
        references Characteristics;

    alter table SEQUENCE 
        add constraint SEQUENCE_ANTIGEN_FK 
        foreign key (ANTIGEN_FK) 
        references ANTIGEN;

    alter table SEQUENCE 
        add constraint SEQUENCEB_FEATURE_FK 
        foreign key (CTERMINUS_FK) 
        references FEATURE;

    alter table SEQUENCE 
        add constraint ANTIBODYBIN_ANTIBODY_FK 
        foreign key (ANTIBODY_FK) 
        references ANTIBODY;

    alter table SEQUENCE 
        add constraint SEQUENPROTEIN_FK 
        foreign key (PROTEIN_FK) 
        references PROTEIN;

    alter table SERVICE 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SERVICEITEM 
        add constraint SERVICTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SERVICEITEM 
        add constraint SERVICEITEM_RATE_FK 
        foreign key (RATE_FK) 
        references RATE;

    alter table SERVICEITEM 
        add constraint SERVICINVOICE_FK 
        foreign key (INVOICE_FK) 
        references INVOICE;

    alter table SERVICEITEM 
        add constraint SERVICBILLIN_FK 
        foreign key (BILLINGINFORMATION_FK) 
        references BILLINGINFORMATION;

    alter table SERVICEITEM 
        add constraint SERVICQUOTAT_FK 
        foreign key (QUOTATION_FK) 
        references QUOTATION;

    alter table SERVICEITEM 
        add constraint SERVICSERVICE_FK 
        foreign key (SERVICE_FK) 
        references SERVICE;

    alter table SMALLMOLECULE 
        add constraint FK_SMALLMOLECULE_MOLECULARSP 
        foreign key (ID) 
        references MOLECULARSPECIMEN;

    alter table SOFTWARE 
        add constraint SOFTWATYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SOFTWARE 
        add constraint SOFTWAEQUIPM_FK 
        foreign key (EQUIPMENT_FK) 
        references EQUIPMENT;

    alter table SOP 
        add constraint SOPCOLTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SOP 
        add constraint SOP_DOCUMENT_FK 
        foreign key (DOCUMENT_FK) 
        references DOCUMENT;

    alter table SOP 
        add constraint SOP_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table SPECIMEN 
        add constraint CHILDSSPECIM_FK 
        foreign key (SPECIMEN_FK) 
        references SPECIMEN;

    alter table SPECIMEN 
        add constraint SPECIMEN_CONTAINER_FK 
        foreign key (CONTAINER_FK) 
        references CONTAINER;

    alter table STANDARDUNIT 
        add constraint FK_STANDARDUNIT_UNIT 
        foreign key (ID) 
        references UNIT;

    alter table STANDARDUNIT 
        add constraint STANDABASEUN_FK 
        foreign key (BASEUNIT_FK) 
        references BASEUNIT;

    alter table STORAGEDEVICE 
        add constraint FK_STORAGEDEVICE_EQUIPMENT 
        foreign key (ID) 
        references EQUIPMENT;

    alter table STORAGESPACE 
        add constraint STORAGTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table STORAGESPACE 
        add constraint STORAGSTORAG_FK 
        foreign key (STORAGEDEVICE_FK) 
        references STORAGEDEVICE;

    alter table STORAGESPACE 
        add constraint STORAGESPACE_LAYOUT_FK 
        foreign key (LAYOUT_FK) 
        references LAYOUT;

    alter table STORAGESPACE 
        add constraint STORAGESPACE_PERSON_FK 
        foreign key (PERSON_FK) 
        references PERSON;

    alter table STRAIN 
        add constraint STRAINTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table STRAIN 
        add constraint ORGANISMSTR_TAXON_FK 
        foreign key (TAXON_FK) 
        references TAXON;

    alter table SUMMARY 
        add constraint SUMMARTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table SUMMARY 
        add constraint SUMMARY_QUERY_FK 
        foreign key (QUERY_FK) 
        references QUERY;

    alter table SafetyCaution_Document 
        add constraint DOCUMENT_SAFETYCAUTIO_ID 
        foreign key (DOCUMENT_ID) 
        references DOCUMENT;

    alter table SafetyCaution_Document 
        add constraint SAFETYCAUTIO_DOCUMENT_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION;

    alter table SafetyCaution_Person 
        add constraint PERSON_SAFETYCAUTIO_ID 
        foreign key (PERSON_ID) 
        references PERSON;

    alter table SafetyCaution_Person 
        add constraint SAFETYCAUTIO_PERSON_ID 
        foreign key (SAFETYCAUTION_ID) 
        references SAFETYCAUTION;

    alter table ServiceItem_AccountNumber 
        add constraint SERVICEITEM_ACCOUNTNUMBE_ID 
        foreign key (SERVICEITEM_ID) 
        references SERVICEITEM;

    alter table ServiceItem_AccountNumber 
        add constraint ACCOUNTNUMBE_SERVICEITEM_ID 
        foreign key (ACCOUNTNUMBER_ID) 
        references ACCOUNTNUMBER;

    alter table Service_CustomerRequest 
        add constraint SERVICE_CUSTOMERREQU_ID 
        foreign key (SERVICE_ID) 
        references SERVICE;

    alter table Service_CustomerRequest 
        add constraint CUSTOMERREQU_SERVICE_ID 
        foreign key (CUSTOMERREQUEST_ID) 
        references CUSTOMERREQUEST;

    alter table Specimen_Organization 
        add constraint ORGANIZATION_SPECIMEN_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table Specimen_Organization 
        add constraint SPECIMEN_ORGANIZATION_ID 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table StorageSpace_Organization 
        add constraint STORAGESPACE_ORGANIZATION_ID 
        foreign key (STORAGESPACE_ID) 
        references STORAGESPACE;

    alter table StorageSpace_Organization 
        add constraint ORGANIZATION_STORAGESPACE_ID 
        foreign key (ORGANIZATION_ID) 
        references ORGANIZATION;

    alter table TELEPHONENUMBER 
        add constraint TELEPHTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table TELEPHONENUMBER 
        add constraint TELEPHCONTAC_FK 
        foreign key (CONTACTINFORMATION_FK) 
        references CONTACTINFORMATION;

    alter table TISSUESPECIMEN 
        add constraint FK_TISSUESPECIMEN_BIOSPECIME 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table UNIFORMRESOURCEIDENTIFIER 
        add constraint UNIFORELECTR_FK 
        foreign key (ELECTRONICDOCUMENT_FK) 
        references ELECTRONICDOCUMENT;

    alter table UNIT 
        add constraint UNITCOTYPE_FK 
        foreign key (TYPE_FK) 
        references TYPE;

    alter table WHOLEORGANISM 
        add constraint FK_WHOLEORGANISM_BIOSPECIMEN 
        foreign key (ID) 
        references BIOSPECIMEN;

    alter table WORD 
        add constraint WORDCONAMING_FK 
        foreign key (NAMINGCONVENTION_FK) 
        references NAMINGCONVENTION;

    alter table WORKSHEET 
        add constraint WORKSHLABSUP_FK 
        foreign key (LABSUPPLY_FK) 
        references LABSUPPLY;

    alter table WORKSHEET 
        add constraint WORKSHEET_SOP_FK 
        foreign key (SOP_FK) 
        references SOP;