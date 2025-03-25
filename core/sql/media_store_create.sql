--    This SQL sript is derived from the Chinook database distributed under the license above. The script is adopted to
--    the Ignite SQL syntax (ANSI-99).

CREATE TABLE Artist
(
    ArtistId INT,
    Name VARCHAR(120),
    PRIMARY KEY (ArtistId)
) WITH "template=partitioned, backups=1, CACHE_NAME=Artist, VALUE_TYPE=org.gridgain.model.Artist";

CREATE TABLE Album
(
    AlbumId INT,
    Title VARCHAR(160),
    ArtistId INT,
    PRIMARY KEY (AlbumId, ArtistId)
) WITH "template=partitioned, backups=1, affinityKey=ArtistId, CACHE_NAME=Album,
        KEY_TYPE=org.gridgain.model.AlbumKey, VALUE_TYPE=org.gridgain.model.Album";

CREATE TABLE Customer
(
    CustomerId INT,
    FirstName VARCHAR(40),
    LastName VARCHAR(20),
    Company VARCHAR(80),
    Address VARCHAR(70),
    City VARCHAR(40),
    State VARCHAR(40),
    Country VARCHAR(40),
    PostalCode VARCHAR(10),
    Phone VARCHAR(24),
    Fax VARCHAR(24),
    Email VARCHAR(60),
    SupportRepId INT,
    PRIMARY KEY (CustomerId)
) WITH "template=partitioned, backups=1, CACHE_NAME=Customer, VALUE_TYPE=org.gridgain.model.Customer";

CREATE TABLE Invoice
(
    InvoiceId INT,
    CustomerId INT,
    InvoiceDate DATE,
    BillingAddress VARCHAR(70),
    BillingCity VARCHAR(40),
    BillingState VARCHAR(40),
    BillingCountry VARCHAR(40),
    BillingPostalCode VARCHAR(10),
    Total DECIMAL(10,2),
    PRIMARY KEY  (InvoiceId, CustomerId)
) WITH "template=partitioned, backups=1, affinityKey=CustomerId, CACHE_NAME=Invoice,
        KEY_TYPE=org.gridgain.model.InvoiceKey, VALUE_TYPE=org.gridgain.model.Invoice";

CREATE TABLE InvoiceLine
(
    InvoiceLineId INT,
    InvoiceId INT,
    CustomerId INT,
    TrackId INT,
    UnitPrice DECIMAL(10,2),
    Quantity INT,
    PRIMARY KEY (InvoiceLineId, CustomerId)
) WITH "template=partitioned, backups=1, affinityKey=CustomerId, CACHE_NAME=InvoiceLine,
        KEY_TYPE=org.gridgain.model.InvoiceLineKey, VALUE_TYPE=org.gridgain.model.InvoiceLine";

CREATE TABLE Employee
(
    EmployeeId INT,
    LastName VARCHAR(20),
    FirstName VARCHAR(20),
    Title VARCHAR(30),
    ReportsTo INT,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR(70),
    City VARCHAR(40),
    State VARCHAR(40),
    Country VARCHAR(40),
    PostalCode VARCHAR(10),
    Phone VARCHAR(24),
    Fax VARCHAR(24),
    Email VARCHAR(60),
    PRIMARY KEY (EmployeeId)
) WITH "template=partitioned, backups=1, CACHE_NAME=Employee, VALUE_TYPE=org.gridgain.model.Employee";

CREATE TABLE Genre
(
    GenreId INT,
    Name VARCHAR(120),
    PRIMARY KEY (GenreId)
) WITH "template=replicated, CACHE_NAME=Genre, VALUE_TYPE=org.gridgain.model.Genre";

CREATE TABLE MediaType
(
    MediaTypeId INT,
    Name VARCHAR(120),
    PRIMARY KEY (MediaTypeId)
) WITH "template=replicated, CACHE_NAME=MediaType, VALUE_TYPE=org.gridgain.model.MediaType";

CREATE TABLE Playlist
(
    PlaylistId INT,
    Name VARCHAR(120),
    PRIMARY KEY  (PlaylistId)
) WITH "template=partitioned, backups=1, CACHE_NAME=PlayList, VALUE_TYPE=org.gridgain.model.PlayList";

CREATE TABLE PlaylistTrack
(
    PlaylistId INT,
    TrackId INT,
    ArtistId INT,
    Dummy TINYINT, /* to fix the issue saying that the table must have at least one non-primary key column */
    PRIMARY KEY (PlaylistId, TrackId, ArtistId)
) WITH "template=partitioned, backups=1, affinityKey=ArtistId, CACHE_NAME=PlayListTrack,
        KEY_TYPE=org.gridgain.model.PlaylistTrackKey, VALUE_TYPE=org.gridgain.model.PlayListTrack";

CREATE TABLE Track
(
    TrackId INT,
    Name VARCHAR(200),
    AlbumId INT,
    ArtistId INT,
    MediaTypeId INT,
    GenreId INT,
    Composer VARCHAR(220),
    Milliseconds INT,
    Bytes INT,
    UnitPrice DECIMAL(10,2),
    PRIMARY KEY (TrackId)
) WITH "template=partitioned, backups=1, CACHE_NAME=Track,
        KEY_TYPE=org.gridgain.model.TrackKey, VALUE_TYPE=org.gridgain.model.Track";