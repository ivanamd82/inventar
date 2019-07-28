create table computer (
      reg_number long not null auto_increment,
      name varchar(255) not null,
      price double not null,
      date_of_purchase date,
      processor varchar(255),
      date_of_processor_installation date,
      chipset varchar(255),
      date_of_chipset_installation date,
      max_memory long,
      memory_installed long,
      date_of_memory_installation varchar(255),
      primary key (reg_number)
);