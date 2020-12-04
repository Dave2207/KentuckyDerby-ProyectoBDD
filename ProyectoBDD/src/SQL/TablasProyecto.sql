create database ProyectoBDD

use ProyectoBDD

--Creacion de tablas e informacion inicial
create table OwnerHorse (
OwnerID int identity(1,1) not null,
FirstName varchar(30) not null,
LastName varchar(30) not null,
StateResidence varchar(40) not null,
constraint PK_Owner primary key (OwnerID))

create table Trainer (
TrainerID int identity(1,1) not null,
FirstName varchar(30) not null,
LastName varchar(30) not null,
StateResidence varchar(40) not null,
constraint PK_Trainer primary key (TrainerID))

create table Breed_Price (
Breed varchar(20) not null,
Price money not null,
constraint PK_Breed primary key (Breed))

create table Horse (
HorseName varchar(20) not null,
Barn varchar(20) not null,
Gender varchar(2) not null,
Age int not null,
Gear varchar(30) not null,
Score int not null,
WonRaces int not null,
Breed varchar(20) not null,
constraint PK_Horse primary key (HorseName),
constraint CK_age check (Age > 0),
constraint CK_Races check (WonRaces > 0),
constraint FK_Breed foreign key (Breed) references Breed_Price(Breed))

create table Owner_Trainer (
OwnerID int not null,
TrainerID int not null,
HorseName varchar(20),
constraint FK_Horse foreign key (HorseName) references Horse(HorseName),
constraint FK_Trainer foreign key (TrainerID) references Trainer(TrainerID),
constraint FK_Owner foreign key (OwnerID) references OwnerHorse(OwnerID))

create table Jockey (
JockeyID int identity(1,1) not null,
FirstName varchar(30) not null,
LastName varchar(30) not null,
Gender varchar(2) not null,
StateResidence varchar(30) not null,
WonRaces int not null,
YearsOfExperience int not null,
Weight_Jockey int not null,
constraint PK_Jockey primary key (JockeyID))

create table Race (
RaceID int identity(1,1) not null,
Distance int not null, 
RaceType varchar(20) not null,
RaceTime Time not null,
RaceDate Date not null,
Weather varchar(20) not null,
constraint PK_Race primary key (RaceID))

create table RaceEntry (
GateNumber int identity(1,1) not null,
JockeyName varchar(30) not null,
Margins int not null, 
FinishPosition int not null,
TimeElapsed int not null,
AmountWon int not null,
HorseName varchar(20) not null,
MorningLineOdds int not null,
FinalOdds int not null,
constraint PK_Entry primary key (GateNumber))

create table Categories (
JockeyID int not null,
HorseName varchar(20) not null,
Category varchar(20) not null,
constraint FK_Jockey foreign key (JockeyID) references Jockey(JockeyID),
constraint FK_HorseCat foreign key (HorseName) references Horse(HorseName))

create table Winner (
GateNumber int not null,
RaceID int not null, 
WinnerJockey varchar(30) not null,
WinnerHorse varchar(30) not null,
constraint FK_GNumb foreign key (GateNumber) references RaceEntry(GateNumber),
constraint FK_Race foreign key (RaceID) references Race(RaceID))

create table Account (
AccountNo int not null,
HasMembership bit not null,
constraint PK_Acc primary key (AccountNo))

create table Spectator (
TicketNo int not null,
BetAmount money not null,
AccountNo int not null,
constraint PK_Spec primary key (TicketNo),
constraint FK_Acc foreign key (AccountNo) references Account(AccountNo))

create table Ticket (
Code int identity(1,1) not null,
PaymentMode varchar(20) not null,
Price money not null,
Race int not null,
BetHorse varchar(20) not null,
DateRace date not null,
TimeRace time not null,
PurchaseDate date not null,
PurchaseTime time not null,
constraint PK_Ticket primary key (Code))

create table Seat (
TicketNo int not null,
Code int not null,
SeatNumber int not null,
SeatType varchar(20) not null,
constraint PK_Seat primary key (SeatNumber),
constraint FK_TicketSeat foreign key (TicketNo) references Spectator(TicketNo))

create table Position (
Position varchar(20) not null,
Salary money not null,
constraint PK_Pos primary key (Position))

create table ZIP (
ZIP_Code int not null,
City varchar(30) not null,
Street varchar(30) not null,
constraint PK_ZIP primary key (ZIP_Code))

create table Employee (
ID int identity(001,1) not null,
FirstName varchar(30) not null,
LastName varchar(30) not null,
Age int not null,
Birthday date not null,
Gender varchar(2) not null,
Position varchar(20) not null,
ZIP_Code int not null,
constraint PK_Employee primary key (ID),
constraint FK_PosEmp foreign key (Position) references Position(Position),
constraint FK_ZIP foreign key (ZIP_Code) references ZIP(ZIP_Code))

insert into Position (Position, Salary)
values ('Veterinario Equino', 30000), 
('Manager', 40000), 
('Cuidador de Caballos', 27500), 
('Taquillero', 15000), 
('Fotógrafo Ecuestre', 25000)

insert into ZIP (ZIP_Code, City, Street) values (51000, 'Santiago', 'Las Carreras')

insert into Breed_Price (Breed, Price) values 
('Arabian', 45000), 
('Morgan', 30000), 
('Mustang', 50000), 
('Standardbred', 70000), 
('Thoroughbred', 73000)

select * from OwnerHorse

create table log_historial (
fecha datetime, 
mensaje varchar(40),
ID_empleado int)
go

create table log_transaccion (
usuario varchar(40),
fechaPago datetime,
PaymentMode varchar(20),
Price money,
Race int,
BetHorse varchar(20),
DateRace date,
TimeRace time)
go
--instead of trigger
create trigger TR_eliminar
on Employee instead of delete
as
begin
insert into log_historial(fecha,mensaje,ID_empleado) select getdate(), 'No se puede eliminar este registro', ID
from deleted
end
go

--DML trigger
create trigger TR_transaccion
on Ticket for insert
as
begin
insert into log_transaccion(usuario,fechaPago,PaymentMode,Price,Race,BetHorse,DateRace,TimeRace)
select SYSTEM_USER,GETDATE(),PaymentMode, Price, Race, BetHorse,DateRace,TimeRace
from inserted
end

