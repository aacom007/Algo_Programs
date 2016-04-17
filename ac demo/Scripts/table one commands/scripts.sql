GO
-- If Already present drop it
DROP DATABASE [ACheckDemo]

-- Create datbase command
GO
CREATE DATABASE [ACheckDemo]

GO
-- use ACheckDemo database
USE [ACheckDemo]
GO

--1. write T-SQL to create table one;
-- create table one
CREATE TABLE [dbo].[one](
	[series] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Series] PRIMARY KEY CLUSTERED([series])
) ON [PRIMARY]

GO

-- Truncate values and then try to add new values.
--Truncate table [dbo].[one]


--2, write T-SQL to insert the following values to table one:
-- Insert command to add new values into table one --
GO
INSERT INTO [dbo].[one]
           ([series])
     VALUES
           ('E1'), 
		   ('E2'), 
		   ('E3'), 
		   ('E4'),
		   ('E5'),
		   ('E6'),
		   ('E7'), 
		   ('E8'),
		   ('E9'),
		   ('E0'),
		   ('F1'),
		   ('F2'), 
		   ('F3'),
		   ('F4'), 
		   ('F5'), 
		   ('F6'), 
		   ('F7'), 
		   ('F8'), 
		   ('F9'),
		   ('F0')



GO
--3. write T-SQL to create table two;
CREATE TABLE [dbo].two(
	[number] [int] NOT NULL,
 CONSTRAINT [PK_number] PRIMARY KEY CLUSTERED([number])
) ON [PRIMARY]

GO

--4. write T-SQL to insert the following values to table two:
INSERT INTO [dbo].[two]
           ([number])
     VALUES
           (1), 
		   (12), 
		   (23), 
		   (34),
		   (45),
		   (56),
		   (67),
		   (78),
		   (89),
		   (1000)
		
 --5. write T-SQL with join to generate the following output:
 -- ONLY USING ONE QUERY
 GO

SELECT
  a.[series] AS 'ESeries',
  b.[series] AS 'FSeries',
  c.[number] 
FROM [dbo].[one] a,
     [dbo].[one] b,
     [dbo].[two] c
WHERE SUBSTRING(a.[series], 0, PATINDEX('%[0-9]%', a.[series])) = 'E'
AND SUBSTRING(b.[series], 0, PATINDEX('%[0-9]%', b.[series])) = 'F'
AND CONVERT(int, SUBSTRING(a.[series], PATINDEX('%[0-9]%', a.[series]), LEN(a.[series]))) = CONVERT(int, SUBSTRING(b.[series], PATINDEX('%[0-9]%', b.[series]), LEN(b.[series])))
AND (CONVERT(int, SUBSTRING(a.[series], PATINDEX('%[0-9]%', a.[series]), LEN(a.[series]))) = 9
AND c.[number] > 90
OR (c.[number]
BETWEEN
CONVERT(int, SUBSTRING(a.[series], PATINDEX('%[0-9]%', a.[series]), LEN(a.[series]))) * 10
AND
(CONVERT(int, SUBSTRING(a.[series], PATINDEX('%[0-9]%', a.[series]), LEN(a.[series]))) + 1) * 10)
)