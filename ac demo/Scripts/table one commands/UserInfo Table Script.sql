/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [username]
      ,[passwordHash]
      ,[firstName]
      ,[lastName]
      ,[emailId]
      ,[middleName]
      ,[phone]
  FROM
 [ACheckDemo].[dbo].[UserInfo];
  
  
 -- truncate table [ACheckDemo].[dbo].[UserInfo];