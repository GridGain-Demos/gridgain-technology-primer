/*
    Copyright (c) 2008-2017 Luis Rocha

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
    documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
    rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
    persons to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
    Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
    TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
    OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
    TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/*
    This SQL sript is derived from the Chinook database distributed under the license above. The script is adopted to
    the Ignite SQL syntax (ANSI-99).
 */

DROP TABLE IF EXISTS Album;
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS Invoice;
DROP TABLE IF EXISTS InvoiceLine;
DROP TABLE IF EXISTS MediaType;
DROP TABLE IF EXISTS Playlist;
DROP TABLE IF EXISTS PlaylistTrack;
DROP TABLE IF EXISTS Track;

DROP ZONE IF EXISTS Chinook;
DROP ZONE IF EXISTS ChinookReplicated;

CREATE ZONE IF NOT EXISTS Chinook WITH replicas=2, storage_profiles='default';
CREATE ZONE IF NOT EXISTS ChinookReplicated WITH replicas=3, partitions=25, storage_profiles='default';

CREATE TABLE Artist
(
    ArtistId INT,
    Name VARCHAR(120),
    PRIMARY KEY (ArtistId)
) ZONE chinook;

CREATE TABLE Album
(
    AlbumId INT,
    Title VARCHAR(160),
    ArtistId INT,
    PRIMARY KEY (AlbumId, ArtistId)
) COLOCATE BY (ArtistId) ZONE chinook ;

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
) ZONE chinook;

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
) COLOCATE BY (CustomerId) ZONE chinook;

CREATE TABLE InvoiceLine
(
    InvoiceLineId INT,
    InvoiceId INT,
    CustomerId INT,
    TrackId INT,
    UnitPrice DECIMAL(10,2),
    Quantity INT,
    PRIMARY KEY (InvoiceLineId, CustomerId)
) COLOCATE BY (CustomerId) ZONE chinook;

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
) ZONE chinook;

CREATE TABLE Genre
(
    GenreId INT,
    Name VARCHAR(120),
    PRIMARY KEY (GenreId)
) ZONE chinookReplicated;

CREATE TABLE MediaType
(
    MediaTypeId INT,
    Name VARCHAR(120),
    PRIMARY KEY (MediaTypeId)
) ZONE chinookReplicated;

CREATE TABLE Playlist
(
    PlaylistId INT,
    Name VARCHAR(120),
    PRIMARY KEY  (PlaylistId)
) ZONE chinook;

CREATE TABLE PlaylistTrack
(
    PlaylistId INT,
    TrackId INT,
    ArtistId INT,
    Dummy TINYINT, /* to fix the issue saying that the table must have at least one non-primary key column */
    PRIMARY KEY (PlaylistId, TrackId, ArtistId)
) COLOCATE BY (ArtistId) ZONE chinook;

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
    PRIMARY KEY (TrackId, ArtistId)
) COLOCATE BY (ArtistId) ZONE chinook;
