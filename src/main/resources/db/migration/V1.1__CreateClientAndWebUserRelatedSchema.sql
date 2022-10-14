CREATE SEQUENCE if not exists hibernate_sequence START 1;

create table IF NOT EXISTS client
(
    web_id        bigint                                 not null
        constraint pk_client
            primary key,
    version       integer                  default 0     not null,
    date_created  timestamp with time zone default now() not null,
    date_updated  timestamp with time zone default now() not null,
    client_number varchar                                not null,
    description   varchar                                not null,
    email         varchar                                not null,
    clientName    varchar                                not null,
    active        boolean                  default true  not null,
    address       varchar
);
create table IF NOT EXISTS project
(
    web_id       bigint                                 not null
        constraint pk_project
            primary key,
    version      integer                  default 0     not null,
    date_created timestamp with time zone default now() not null,
    date_updated timestamp with time zone default now() not null,
    project_name varchar                                not null,
    client       varchar                                not null,
    amount       varchar                                not null,
    active       boolean                  default true  not null
);
create table IF NOT EXISTS team
(
    web_id       bigint                                 not null
        constraint pk_team
            primary key,
    version      integer                  default 0     not null,
    date_created timestamp with time zone default now() not null,
    date_updated timestamp with time zone default now() not null,
    first_name   varchar                                not null,
    last_name    varchar                                not null,
    gender       varchar                                not null,
    role         varchar                                not null,
    age          varchar                                not null,
    active       boolean                  default true  not null,
    phone_number varchar,
    email        varchar,
    password     varchar,
    address      varchar
);
create table IF NOT EXISTS tracker
(
    web_id       bigint                                 not null
        constraint pk_tracker
            primary key,
    version      integer                  default 0     not null,
    date_created timestamp with time zone default now() not null,
    date_updated timestamp with time zone default now() not null,
    title        varchar                                not null,
    amount       int                                    not null,
    participant  varchar                                not null,
    start_time   varchar                                not null,
    end_time     varchar                                not null,
    active       boolean                  default true
);

create index if not exists ix_enterprise__active
    on client (active);

create table if not exists role
(
    web_id       bigint                  not null
        constraint pk_role
            primary key,
    version      integer   default 0     not null,
    date_created timestamp default now() not null,
    date_updated timestamp default now() not null,
    external_key varchar                 not null,
    role_code    varchar,
    title        varchar                 not null,
    description  varchar,
    use          text,
    active       boolean   default true,
    CONSTRAINT role__use
        CHECK ((use::text = ('CUSTOMER')::text) OR (use::text = ('STAFF')::text)
            OR (use::text = ('ALL')::text))
);
comment on table role is 'authentication.  This table defines the roles that users can have.';
create index if not exists ix_role__external_key
    on role (external_key);
create table if not exists permission_group
(
    web_id        bigint                                 not null
        constraint pk_permission_group
            primary key,
    version       integer                  default 0     not null,
    date_created  timestamp with time zone default now() not null,
    date_updated  timestamp with time zone default now() not null,
    description   varchar                                not null,
    group_code    varchar,
    parent_web_id bigint
);
create table if not exists permission
(
    web_id              bigint                                 not null
        constraint pk_permission
            primary key,
    version             integer                  default 0     not null,
    date_created        timestamp with time zone default now() not null,
    date_updated        timestamp with time zone default now() not null,
    permission_code     varchar                                not null,
    title               varchar                                not null,
    description         varchar                                not null,
    permission_group_id bigint,
    use                 text,
    active              boolean                  default true,
    CONSTRAINT permission__use
        CHECK ((use::text = ('CUSTOMER')::text) OR (use::text = ('STAFF')::text)
            OR (use::text = ('ALL')::text))
);
comment on table permission is 'common, authentication';
create table if not exists role_permission
(
    web_id        bigint                                 not null
        constraint pk_role_permission
            primary key,
    version       integer                  default 0     not null,
    date_created  timestamp with time zone default now() not null,
    date_updated  timestamp with time zone default now() not null,
    role_id       bigint                                 not null
        constraint fk_role_permission__role
            references role on delete cascade,
    permission_id bigint                                 not null
        constraint fk_role_permission__permission
            references permission on delete cascade
);
comment on table role_permission is 'common, authentication';
create index if not exists ix_role_permission__web_user
    on role_permission (role_id);
create index if not exists ix_role_permission__permission
    on role_permission (permission_id);
create table IF NOT EXISTS web_user
(
    web_id       bigint                                 not null
        constraint pk_web_user
            primary key,
    version      integer                  default 0     not null,
    date_created timestamp with time zone default now() not null,
    date_updated timestamp with time zone default now() not null,
    status       integer                  default 0     not null,
    first_name   varchar,
    last_name    varchar,
    email        varchar,
    phone        varchar,
    user_name    varchar,
    password     varchar,
    gender       int,
    dob          timestamp with time zone,
    active       boolean                  default true,
    middle_name  varchar,
    time_zone    timestamp with time zone,
    language     varchar
);
create index if not exists ix_web_user__gender
    on web_user (gender);
create index if not exists ix_web_user__phone
    on web_user (phone);
create index if not exists ix_web_user__user_name
    on web_user (user_name);
create unique index if not exists ix_web_user__email
    on web_user (email);
create table IF NOT EXISTS web_user_role
(
    web_id       bigint                                 not null
        constraint pk_web_user_role
            primary key,
    version      integer                  default 0     not null,
    date_created timestamp with time zone default now() not null,
    date_updated timestamp with time zone default now() not null,
    web_user_id  bigint
        constraint fk_web_user_role__web_user
            references web_user on delete cascade,
    role_id      bigint                                 not null
        CONSTRAINT fk_web_user_role__role REFERENCES role (web_id),
    active       boolean                  default true
);
create table IF NOT EXISTS web_user_permission
(
    web_id        bigint                                 not null
        constraint pk_web_user_permission
            primary key,
    version       integer                  default 0     not null,
    date_created  timestamp with time zone default now() not null,
    date_updated  timestamp with time zone default now() not null,
    web_user_id   bigint
        constraint fk_web_user_permission__web_user
            references web_user on delete cascade,
    permission_id bigint                                 not null
        CONSTRAINT fk_web_user_permission__permission REFERENCES permission (web_id),
    active        boolean                  default true
);
create unique index IF NOT EXISTS uq_web_user_permission__web_user_id
    on web_user_permission (web_user_id);
create table IF NOT EXISTS web_user_permission_group
(
    web_id              bigint                                 not null
        constraint pk_web_user_permission_group
            primary key,
    version             integer                  default 0     not null,
    date_created        timestamp with time zone default now() not null,
    date_updated        timestamp with time zone default now() not null,
    web_user_id         bigint
        constraint fk_web_user_permission_group__web_user
            references web_user on delete cascade,
    permission_id       bigint
        constraint fk_web_user_permission_group__web_user_permission
            references web_user_permission on delete cascade,
    permission_group_id bigint                                 not null
        constraint fk_web_user_permission_group__permission_group
            references permission_group on delete cascade,
    permission          varchar(20),
    active              boolean                  default true
);
create unique index IF NOT EXISTS uq_web_user_permission_group__permission_id
    on web_user_permission_group (permission_id);
create unique index IF NOT EXISTS uq_web_user_permission_group__web_user_id
    on web_user_permission_group (web_user_id);
