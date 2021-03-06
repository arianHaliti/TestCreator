USE [TestCreator1]
GO
/****** Object:  Table [dbo].[Addresses]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Addresses](
	[AddressID] [int] IDENTITY(1,1) NOT NULL,
	[StudentID] [int] NOT NULL,
	[City_ID] [int] NOT NULL,
	[StreetName] [varchar](50) NOT NULL,
 CONSTRAINT [AddressID_PK] PRIMARY KEY CLUSTERED 
(
	[AddressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Answers](
	[AnswerID] [int] IDENTITY(1,1) NOT NULL,
	[Question_FK] [int] NOT NULL,
	[Answer_correct] [bit] NOT NULL,
	[Answer_Desc] [varchar](1000) NOT NULL,
 CONSTRAINT [AnswerID_pk] PRIMARY KEY CLUSTERED 
(
	[AnswerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cities]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cities](
	[City_ID] [int] IDENTITY(1,1) NOT NULL,
	[City_Name] [varchar](50) NOT NULL,
	[Country_ID] [int] NOT NULL,
 CONSTRAINT [City_ID] PRIMARY KEY CLUSTERED 
(
	[City_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Countries]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Countries](
	[Country_ID] [int] IDENTITY(1,1) NOT NULL,
	[Country_name] [varchar](100) NOT NULL,
 CONSTRAINT [Country_IDPK] PRIMARY KEY CLUSTERED 
(
	[Country_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Emails]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Emails](
	[EmailID] [int] IDENTITY(1,1) NOT NULL,
	[EmailAdress] [varchar](50) NOT NULL,
	[UserID] [int] NOT NULL,
 CONSTRAINT [EmailID_PK] PRIMARY KEY CLUSTERED 
(
	[EmailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phone]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phone](
	[PhoneNumberID] [int] IDENTITY(1,1) NOT NULL,
	[PhoneNumber] [varchar](30) NOT NULL,
	[UserID] [int] NOT NULL,
 CONSTRAINT [PhoneNumberID_PK] PRIMARY KEY CLUSTERED 
(
	[PhoneNumberID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Profesor_Subjects]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profesor_Subjects](
	[Profesor_SubjectID] [int] IDENTITY(1,1) NOT NULL,
	[ProfesorID] [int] NOT NULL,
	[SubjectID] [int] NOT NULL,
 CONSTRAINT [Profesor_Subject_PK] PRIMARY KEY CLUSTERED 
(
	[Profesor_SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Profesors]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Profesors](
	[ProfesorID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[Degree] [varchar](50) NULL,
 CONSTRAINT [ProfesorID_pk] PRIMARY KEY CLUSTERED 
(
	[ProfesorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Programs]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Programs](
	[ProgramsID] [int] IDENTITY(1,1) NOT NULL,
	[ProgramName] [varchar](100) NOT NULL,
	[Master] [bit] NOT NULL,
 CONSTRAINT [ProgramID_PK] PRIMARY KEY CLUSTERED 
(
	[ProgramsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Programs_Subjects]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Programs_Subjects](
	[Program_SubjectID] [int] IDENTITY(1,1) NOT NULL,
	[Profesor_SubjectID] [int] NOT NULL,
	[ProgramID] [int] NOT NULL,
 CONSTRAINT [Program_SubjecID_PK] PRIMARY KEY CLUSTERED 
(
	[Program_SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Questions]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Questions](
	[QuestionID] [int] IDENTITY(1,1) NOT NULL,
	[Test_FK] [int] NOT NULL,
	[PointNr] [int] NOT NULL,
	[Question_Type] [int] NOT NULL,
	[Option_nr] [int] NOT NULL,
	[Question_Desc] [varchar](1000) NOT NULL,
 CONSTRAINT [QuestionID_PK] PRIMARY KEY CLUSTERED 
(
	[QuestionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student_Answer_Test]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Answer_Test](
	[Student_AT_ID] [int] IDENTITY(1,1) NOT NULL,
	[AnswerID] [int] NOT NULL,
	[Test_StudentID] [int] NOT NULL,
	[Answer_S_ID] [int] NOT NULL,
	[QuestionID] [int] NOT NULL,
 CONSTRAINT [Student_AT_ID_PK] PRIMARY KEY CLUSTERED 
(
	[Student_AT_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Student_Answers]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Answers](
	[Answer_S_ID] [int] IDENTITY(1,1) NOT NULL,
	[Answer_Ticked] [bit] NOT NULL,
 CONSTRAINT [Answer_S_ID_PK] PRIMARY KEY CLUSTERED 
(
	[Answer_S_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Student_Test]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Test](
	[Test_StudentID] [int] IDENTITY(1,1) NOT NULL,
	[TestID] [int] NOT NULL,
	[StudentID] [int] NOT NULL,
	[nrPikeve] [int] NOT NULL,
	[testDone] [bit] NOT NULL,
 CONSTRAINT [Test_StudentID_pk] PRIMARY KEY CLUSTERED 
(
	[Test_StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Students]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Students](
	[StudentID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[ProgramID] [int] NOT NULL,
	[ParentName] [varchar](50) NULL,
	[DateOfBirth] [date] NOT NULL,
	[Gender] [char](1) NOT NULL,
	[PersonalNumber] [varchar](30) NOT NULL,
	[inTestStatus] [bit] NOT NULL,
 CONSTRAINT [StudentID_pk] PRIMARY KEY CLUSTERED 
(
	[StudentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Subjects]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Subjects](
	[SubjectID] [int] IDENTITY(1,1) NOT NULL,
	[SubjectName] [varchar](50) NOT NULL,
	[Credits] [int] NOT NULL,
 CONSTRAINT [Subject_pk] PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Test]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Test](
	[TestID] [int] IDENTITY(1,1) NOT NULL,
	[TestActive] [bit] NOT NULL,
	[Program_SubjectID] [int] NOT NULL,
	[TestName] [varchar](140) NOT NULL,
	[nrQuestions] [int] NOT NULL,
	[Points] [int] NOT NULL,
	[Descriptions] [varchar](250) NULL,
	[Duration] [int] NOT NULL,
 CONSTRAINT [TestID_pk] PRIMARY KEY CLUSTERED 
(
	[TestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/1/2017 10:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[LoginName] [varchar](30) NOT NULL,
	[HashCode] [varchar](50) NOT NULL,
	[FirstName] [varchar](50) NOT NULL,
	[SurName] [varchar](50) NOT NULL,
	[Privilege] [int] NOT NULL,
 CONSTRAINT [UserID_pk] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Addresses] ON 

INSERT [dbo].[Addresses] ([AddressID], [StudentID], [City_ID], [StreetName]) VALUES (5, 2, 7, N'NoN')
INSERT [dbo].[Addresses] ([AddressID], [StudentID], [City_ID], [StreetName]) VALUES (6, 3, 3, N'NoN')
INSERT [dbo].[Addresses] ([AddressID], [StudentID], [City_ID], [StreetName]) VALUES (7, 4, 3, N'NoN')
INSERT [dbo].[Addresses] ([AddressID], [StudentID], [City_ID], [StreetName]) VALUES (8, 5, 2, N'NoN')
SET IDENTITY_INSERT [dbo].[Addresses] OFF
SET IDENTITY_INSERT [dbo].[Answers] ON 

INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (57, 25, 1, N'PO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (58, 25, 0, N'JO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (59, 26, 0, N'PO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (60, 26, 1, N'JO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (61, 27, 1, N's')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (62, 27, 0, N'd')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (63, 27, 0, N'f')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (64, 28, 1, N'PO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (65, 28, 0, N'JO')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (66, 29, 0, N'Data modifie league')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (67, 29, 0, N'Date Model Language')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (68, 30, 1, N'select')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (69, 30, 0, N'for loop')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (70, 30, 0, N'if else')
INSERT [dbo].[Answers] ([AnswerID], [Question_FK], [Answer_correct], [Answer_Desc]) VALUES (71, 30, 1, N'check')
SET IDENTITY_INSERT [dbo].[Answers] OFF
SET IDENTITY_INSERT [dbo].[Cities] ON 

INSERT [dbo].[Cities] ([City_ID], [City_Name], [Country_ID]) VALUES (2, N'Prishtina', 11)
INSERT [dbo].[Cities] ([City_ID], [City_Name], [Country_ID]) VALUES (3, N'Peja', 11)
INSERT [dbo].[Cities] ([City_ID], [City_Name], [Country_ID]) VALUES (5, N'Ulqini', 12)
INSERT [dbo].[Cities] ([City_ID], [City_Name], [Country_ID]) VALUES (7, N'Shkupi', 14)
SET IDENTITY_INSERT [dbo].[Cities] OFF
SET IDENTITY_INSERT [dbo].[Countries] ON 

INSERT [dbo].[Countries] ([Country_ID], [Country_name]) VALUES (11, N'Kosova')
INSERT [dbo].[Countries] ([Country_ID], [Country_name]) VALUES (12, N'Mali i zi')
INSERT [dbo].[Countries] ([Country_ID], [Country_name]) VALUES (14, N'Maqedonia')
SET IDENTITY_INSERT [dbo].[Countries] OFF
SET IDENTITY_INSERT [dbo].[Emails] ON 

INSERT [dbo].[Emails] ([EmailID], [EmailAdress], [UserID]) VALUES (1, N'prof@prof.com', 2)
SET IDENTITY_INSERT [dbo].[Emails] OFF
SET IDENTITY_INSERT [dbo].[Phone] ON 

INSERT [dbo].[Phone] ([PhoneNumberID], [PhoneNumber], [UserID]) VALUES (1, N'04413231', 2)
SET IDENTITY_INSERT [dbo].[Phone] OFF
SET IDENTITY_INSERT [dbo].[Profesor_Subjects] ON 

INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (1, 1, 2)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (3, 1, 3)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (4, 2, 3)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (5, 2, 1)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (6, 3, 2)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (7, 3, 3)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (8, 3, 1)
INSERT [dbo].[Profesor_Subjects] ([Profesor_SubjectID], [ProfesorID], [SubjectID]) VALUES (9, 1, 1)
SET IDENTITY_INSERT [dbo].[Profesor_Subjects] OFF
SET IDENTITY_INSERT [dbo].[Profesors] ON 

INSERT [dbo].[Profesors] ([ProfesorID], [UserID], [DateOfBirth], [Degree]) VALUES (1, 2, CAST(0x931A0B00 AS Date), N'Bachelor')
INSERT [dbo].[Profesors] ([ProfesorID], [UserID], [DateOfBirth], [Degree]) VALUES (2, 5, CAST(0x24190B00 AS Date), N'Master')
INSERT [dbo].[Profesors] ([ProfesorID], [UserID], [DateOfBirth], [Degree]) VALUES (3, 6, CAST(0x44160B00 AS Date), N'Bachelor')
SET IDENTITY_INSERT [dbo].[Profesors] OFF
SET IDENTITY_INSERT [dbo].[Programs] ON 

INSERT [dbo].[Programs] ([ProgramsID], [ProgramName], [Master]) VALUES (1, N'SHKI', 1)
INSERT [dbo].[Programs] ([ProgramsID], [ProgramName], [Master]) VALUES (3, N'Arkitektur', 1)
SET IDENTITY_INSERT [dbo].[Programs] OFF
SET IDENTITY_INSERT [dbo].[Programs_Subjects] ON 

INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (5, 1, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (6, 6, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (7, 4, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (8, 5, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (9, 8, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (10, 1, 3)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (11, 3, 3)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (12, 4, 3)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (13, 9, 1)
INSERT [dbo].[Programs_Subjects] ([Program_SubjectID], [Profesor_SubjectID], [ProgramID]) VALUES (14, 3, 1)
SET IDENTITY_INSERT [dbo].[Programs_Subjects] OFF
SET IDENTITY_INSERT [dbo].[Questions] ON 

INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (25, 21, 3, 0, 2, N'PSE?5')
INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (26, 21, 2, 0, 2, N'kushj')
INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (27, 21, 5, 1, 3, N'kusj')
INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (28, 22, 10, 0, 2, N'DAtabaza ruan te dhenat ?')
INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (29, 22, 10, 1, 2, N'DML?')
INSERT [dbo].[Questions] ([QuestionID], [Test_FK], [PointNr], [Question_Type], [Option_nr], [Question_Desc]) VALUES (30, 22, 10, 1, 4, N'Query')
SET IDENTITY_INSERT [dbo].[Questions] OFF
SET IDENTITY_INSERT [dbo].[Student_Answer_Test] ON 

INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (425, 57, 61, 425, 25)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (426, 58, 61, 426, 25)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (427, 59, 61, 427, 26)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (428, 60, 61, 428, 26)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (429, 61, 61, 429, 27)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (430, 62, 61, 430, 27)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (431, 63, 61, 431, 27)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (432, 64, 62, 432, 28)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (433, 65, 62, 433, 28)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (434, 66, 62, 434, 29)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (435, 67, 62, 435, 29)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (436, 68, 62, 436, 30)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (437, 69, 62, 437, 30)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (438, 70, 62, 438, 30)
INSERT [dbo].[Student_Answer_Test] ([Student_AT_ID], [AnswerID], [Test_StudentID], [Answer_S_ID], [QuestionID]) VALUES (439, 71, 62, 439, 30)
SET IDENTITY_INSERT [dbo].[Student_Answer_Test] OFF
SET IDENTITY_INSERT [dbo].[Student_Answers] ON 

INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (425, 1)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (426, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (427, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (428, 1)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (429, 1)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (430, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (431, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (432, 1)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (433, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (434, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (435, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (436, 1)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (437, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (438, 0)
INSERT [dbo].[Student_Answers] ([Answer_S_ID], [Answer_Ticked]) VALUES (439, 1)
SET IDENTITY_INSERT [dbo].[Student_Answers] OFF
SET IDENTITY_INSERT [dbo].[Student_Test] ON 

INSERT [dbo].[Student_Test] ([Test_StudentID], [TestID], [StudentID], [nrPikeve], [testDone]) VALUES (61, 21, 5, 10, 1)
INSERT [dbo].[Student_Test] ([Test_StudentID], [TestID], [StudentID], [nrPikeve], [testDone]) VALUES (62, 22, 5, 30, 1)
SET IDENTITY_INSERT [dbo].[Student_Test] OFF
SET IDENTITY_INSERT [dbo].[Students] ON 

INSERT [dbo].[Students] ([StudentID], [UserID], [ProgramID], [ParentName], [DateOfBirth], [Gender], [PersonalNumber], [inTestStatus]) VALUES (2, 4, 1, N'', CAST(0x861A0B00 AS Date), N'M', N'312321313', 0)
INSERT [dbo].[Students] ([StudentID], [UserID], [ProgramID], [ParentName], [DateOfBirth], [Gender], [PersonalNumber], [inTestStatus]) VALUES (3, 10, 3, N'', CAST(0x841A0B00 AS Date), N'M', N'51521131', 0)
INSERT [dbo].[Students] ([StudentID], [UserID], [ProgramID], [ParentName], [DateOfBirth], [Gender], [PersonalNumber], [inTestStatus]) VALUES (4, 11, 1, N'', CAST(0xCC1E0B00 AS Date), N'M', N'5351231', 0)
INSERT [dbo].[Students] ([StudentID], [UserID], [ProgramID], [ParentName], [DateOfBirth], [Gender], [PersonalNumber], [inTestStatus]) VALUES (5, 14, 1, N'', CAST(0xAA1A0B00 AS Date), N'M', N'5134213', 0)
SET IDENTITY_INSERT [dbo].[Students] OFF
SET IDENTITY_INSERT [dbo].[Subjects] ON 

INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Credits]) VALUES (1, N'Databaz', 15)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Credits]) VALUES (2, N'Math', 5)
INSERT [dbo].[Subjects] ([SubjectID], [SubjectName], [Credits]) VALUES (3, N'Algoritme', 7)
SET IDENTITY_INSERT [dbo].[Subjects] OFF
SET IDENTITY_INSERT [dbo].[Test] ON 

INSERT [dbo].[Test] ([TestID], [TestActive], [Program_SubjectID], [TestName], [nrQuestions], [Points], [Descriptions], [Duration]) VALUES (21, 1, 5, N'Math', 3, 10, N'Përdorimi i librave, materialeve dhe shënimeve tjera nuk lejohet.
 Biseda me studentët tjerë gjatë kolokfiumit apo 
kopjiminuk lejohet. Mashtrimi apo çfarëdo dhunimi
 tjetër i këtyre rregullave do të rezultojë me Zero pikë.', 6)
INSERT [dbo].[Test] ([TestID], [TestActive], [Program_SubjectID], [TestName], [nrQuestions], [Points], [Descriptions], [Duration]) VALUES (22, 1, 13, N'Databaz', 3, 30, N'Përdorimi i librave, materialeve dhe shënimeve tjera nuk lejohet.
 Biseda me studentët tjerë gjatë kolokfiumit apo 
kopjiminuk lejohet. Mashtrimi apo çfarëdo dhunimi
 tjetër i këtyre rregullave do të rezultojë me Zero pikë.', 6)
SET IDENTITY_INSERT [dbo].[Test] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (2, N'2', N'2', N'prof', N'prof', 1)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (4, N'6', N'6', N'Lrim', N'Hyseni', 2)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (5, N'blerim2', N'password', N'Blerim', N'Zylfiu', 1)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (6, N'7', N'7', N'Fisnik', N'Prekazi', 1)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (7, N'1', N'1', N'admin', N'admin', 0)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (10, N'8', N'8', N'Filan', N'Fisteku', 2)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (11, N'ys', N'ys', N'Yllzon', N'Sejdiu', 2)
INSERT [dbo].[Users] ([UserID], [LoginName], [HashCode], [FirstName], [SurName], [Privilege]) VALUES (14, N'3', N'3', N'Arian', N'Haliti', 2)
SET IDENTITY_INSERT [dbo].[Users] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Cities__9FF0D1462606D46A]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Cities] ADD UNIQUE NONCLUSTERED 
(
	[City_Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Countrie__BD1A4C813B1855BE]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Countries] ADD UNIQUE NONCLUSTERED 
(
	[Country_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ__Emails__7ED91AEE9164EB78]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Emails] ADD UNIQUE NONCLUSTERED 
(
	[EmailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Emails__A84E0284F529BD82]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Emails] ADD UNIQUE NONCLUSTERED 
(
	[EmailAdress] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Phone__85FB4E38D6FF81B9]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Phone] ADD UNIQUE NONCLUSTERED 
(
	[PhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Subjects__4C5A7D5540C2187F]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Subjects] ADD UNIQUE NONCLUSTERED 
(
	[SubjectName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [Login_Unique]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [Login_Unique] UNIQUE NONCLUSTERED 
(
	[LoginName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UQ__Users__DB8464FF9C984EF2]    Script Date: 6/1/2017 10:15:15 PM ******/
ALTER TABLE [dbo].[Users] ADD UNIQUE NONCLUSTERED 
(
	[LoginName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Addresses]  WITH CHECK ADD  CONSTRAINT [City_IDFK] FOREIGN KEY([City_ID])
REFERENCES [dbo].[Cities] ([City_ID])
GO
ALTER TABLE [dbo].[Addresses] CHECK CONSTRAINT [City_IDFK]
GO
ALTER TABLE [dbo].[Addresses]  WITH CHECK ADD  CONSTRAINT [StudentID_Add_FK] FOREIGN KEY([StudentID])
REFERENCES [dbo].[Students] ([StudentID])
GO
ALTER TABLE [dbo].[Addresses] CHECK CONSTRAINT [StudentID_Add_FK]
GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD  CONSTRAINT [Question_FK_FK] FOREIGN KEY([Question_FK])
REFERENCES [dbo].[Questions] ([QuestionID])
GO
ALTER TABLE [dbo].[Answers] CHECK CONSTRAINT [Question_FK_FK]
GO
ALTER TABLE [dbo].[Cities]  WITH CHECK ADD  CONSTRAINT [Country_IDFK] FOREIGN KEY([Country_ID])
REFERENCES [dbo].[Countries] ([Country_ID])
GO
ALTER TABLE [dbo].[Cities] CHECK CONSTRAINT [Country_IDFK]
GO
ALTER TABLE [dbo].[Emails]  WITH CHECK ADD  CONSTRAINT [UserID_Emails] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Emails] CHECK CONSTRAINT [UserID_Emails]
GO
ALTER TABLE [dbo].[Phone]  WITH CHECK ADD  CONSTRAINT [UserID_Phone_FK] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Phone] CHECK CONSTRAINT [UserID_Phone_FK]
GO
ALTER TABLE [dbo].[Profesor_Subjects]  WITH CHECK ADD  CONSTRAINT [ProfesorID_PS_FK] FOREIGN KEY([ProfesorID])
REFERENCES [dbo].[Profesors] ([ProfesorID])
GO
ALTER TABLE [dbo].[Profesor_Subjects] CHECK CONSTRAINT [ProfesorID_PS_FK]
GO
ALTER TABLE [dbo].[Profesor_Subjects]  WITH CHECK ADD  CONSTRAINT [SubjectID_PS_FK] FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subjects] ([SubjectID])
GO
ALTER TABLE [dbo].[Profesor_Subjects] CHECK CONSTRAINT [SubjectID_PS_FK]
GO
ALTER TABLE [dbo].[Profesors]  WITH CHECK ADD  CONSTRAINT [UserID_Prof_fk] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Profesors] CHECK CONSTRAINT [UserID_Prof_fk]
GO
ALTER TABLE [dbo].[Programs_Subjects]  WITH CHECK ADD  CONSTRAINT [Profesor_SubjectID_FK] FOREIGN KEY([Profesor_SubjectID])
REFERENCES [dbo].[Profesor_Subjects] ([Profesor_SubjectID])
GO
ALTER TABLE [dbo].[Programs_Subjects] CHECK CONSTRAINT [Profesor_SubjectID_FK]
GO
ALTER TABLE [dbo].[Programs_Subjects]  WITH CHECK ADD  CONSTRAINT [ProgramID_FK1] FOREIGN KEY([ProgramID])
REFERENCES [dbo].[Programs] ([ProgramsID])
GO
ALTER TABLE [dbo].[Programs_Subjects] CHECK CONSTRAINT [ProgramID_FK1]
GO
ALTER TABLE [dbo].[Questions]  WITH CHECK ADD  CONSTRAINT [Test_q_FK] FOREIGN KEY([Test_FK])
REFERENCES [dbo].[Test] ([TestID])
GO
ALTER TABLE [dbo].[Questions] CHECK CONSTRAINT [Test_q_FK]
GO
ALTER TABLE [dbo].[Student_Answer_Test]  WITH CHECK ADD  CONSTRAINT [Answer_S_ID_FK] FOREIGN KEY([Answer_S_ID])
REFERENCES [dbo].[Student_Answers] ([Answer_S_ID])
GO
ALTER TABLE [dbo].[Student_Answer_Test] CHECK CONSTRAINT [Answer_S_ID_FK]
GO
ALTER TABLE [dbo].[Student_Answer_Test]  WITH CHECK ADD  CONSTRAINT [AnswerID_sat_fk] FOREIGN KEY([AnswerID])
REFERENCES [dbo].[Answers] ([AnswerID])
GO
ALTER TABLE [dbo].[Student_Answer_Test] CHECK CONSTRAINT [AnswerID_sat_fk]
GO
ALTER TABLE [dbo].[Student_Answer_Test]  WITH CHECK ADD  CONSTRAINT [QuestionID_S_FK] FOREIGN KEY([QuestionID])
REFERENCES [dbo].[Questions] ([QuestionID])
GO
ALTER TABLE [dbo].[Student_Answer_Test] CHECK CONSTRAINT [QuestionID_S_FK]
GO
ALTER TABLE [dbo].[Student_Answer_Test]  WITH CHECK ADD  CONSTRAINT [Test_StundetID_FK] FOREIGN KEY([Test_StudentID])
REFERENCES [dbo].[Student_Test] ([Test_StudentID])
GO
ALTER TABLE [dbo].[Student_Answer_Test] CHECK CONSTRAINT [Test_StundetID_FK]
GO
ALTER TABLE [dbo].[Student_Test]  WITH CHECK ADD  CONSTRAINT [Student_st_FK] FOREIGN KEY([StudentID])
REFERENCES [dbo].[Students] ([StudentID])
GO
ALTER TABLE [dbo].[Student_Test] CHECK CONSTRAINT [Student_st_FK]
GO
ALTER TABLE [dbo].[Student_Test]  WITH CHECK ADD  CONSTRAINT [Test_st_FK] FOREIGN KEY([TestID])
REFERENCES [dbo].[Test] ([TestID])
GO
ALTER TABLE [dbo].[Student_Test] CHECK CONSTRAINT [Test_st_FK]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [ProgramID_Std_Fk] FOREIGN KEY([ProgramID])
REFERENCES [dbo].[Programs] ([ProgramsID])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [ProgramID_Std_Fk]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [User_Std_Fk] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([UserID])
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [User_Std_Fk]
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD  CONSTRAINT [Program_Subject_FK] FOREIGN KEY([Program_SubjectID])
REFERENCES [dbo].[Programs_Subjects] ([Program_SubjectID])
GO
ALTER TABLE [dbo].[Test] CHECK CONSTRAINT [Program_Subject_FK]
GO
ALTER TABLE [dbo].[Students]  WITH CHECK ADD  CONSTRAINT [Gender_Check] CHECK  (([Gender] like 'F' OR [Gender] like 'M'))
GO
ALTER TABLE [dbo].[Students] CHECK CONSTRAINT [Gender_Check]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [Privilege_check] CHECK  (([Privilege]>=(0) OR [Privilege]<=(2)))
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [Privilege_check]
GO
