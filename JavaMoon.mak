# Microsoft Developer Studio Generated NMAKE File, Format Version 4.20
# ** DO NOT EDIT **

# TARGTYPE "Java Virtual Machine Java Workspace" 0x0809

!IF "$(CFG)" == ""
CFG=JavaMoon - Java Virtual Machine Debug
!MESSAGE No configuration specified.  Defaulting to JavaMoon - Java Virtual\
 Machine Debug.
!ENDIF 

!IF "$(CFG)" != "JavaMoon - Java Virtual Machine Release" && "$(CFG)" !=\
 "JavaMoon - Java Virtual Machine Debug"
!MESSAGE Invalid configuration "$(CFG)" specified.
!MESSAGE You can specify a configuration when running NMAKE on this makefile
!MESSAGE by defining the macro CFG on the command line.  For example:
!MESSAGE 
!MESSAGE NMAKE /f "JavaMoon.mak" CFG="JavaMoon - Java Virtual Machine Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "JavaMoon - Java Virtual Machine Release" (based on\
 "Java Virtual Machine Java Workspace")
!MESSAGE "JavaMoon - Java Virtual Machine Debug" (based on\
 "Java Virtual Machine Java Workspace")
!MESSAGE 
!ERROR An invalid configuration is specified.
!ENDIF 

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE 
NULL=nul
!ENDIF 
################################################################################
# Begin Project
# PROP Target_Last_Scanned "JavaMoon - Java Virtual Machine Debug"
JAVA=jvc.exe

!IF  "$(CFG)" == "JavaMoon - Java Virtual Machine Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir ""
# PROP BASE Intermediate_Dir ""
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir ""
# PROP Intermediate_Dir ""
# PROP Target_Dir ""
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\Moon.class" "$(OUTDIR)\MoonCalc.class"

CLEAN : 
	-@erase "$(INTDIR)\Moon.class"
	-@erase "$(INTDIR)\MoonCalc.class"

# ADD BASE JAVA /O
# ADD JAVA /O
# SUBTRACT JAVA /g

!ELSEIF  "$(CFG)" == "JavaMoon - Java Virtual Machine Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir ""
# PROP BASE Intermediate_Dir ""
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir ""
# PROP Intermediate_Dir ""
# PROP Target_Dir ""
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\Moon.class" "$(OUTDIR)\MoonCalc.class"

CLEAN : 
	-@erase "$(INTDIR)\Moon.class"
	-@erase "$(INTDIR)\MoonCalc.class"

# ADD BASE JAVA /g
# ADD JAVA /O
# SUBTRACT JAVA /g

!ENDIF 

################################################################################
# Begin Target

# Name "JavaMoon - Java Virtual Machine Release"
# Name "JavaMoon - Java Virtual Machine Debug"

!IF  "$(CFG)" == "JavaMoon - Java Virtual Machine Release"

!ELSEIF  "$(CFG)" == "JavaMoon - Java Virtual Machine Debug"

!ENDIF 

################################################################################
# Begin Source File

SOURCE=.\Moon.java

!IF  "$(CFG)" == "JavaMoon - Java Virtual Machine Release"


"$(INTDIR)\Moon.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "JavaMoon - Java Virtual Machine Debug"


"$(INTDIR)\Moon.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\MoonCalc.java

!IF  "$(CFG)" == "JavaMoon - Java Virtual Machine Release"


"$(INTDIR)\MoonCalc.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "JavaMoon - Java Virtual Machine Debug"


"$(INTDIR)\MoonCalc.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\Moon.html

!IF  "$(CFG)" == "JavaMoon - Java Virtual Machine Release"

!ELSEIF  "$(CFG)" == "JavaMoon - Java Virtual Machine Debug"

!ENDIF 

# End Source File
# End Target
# End Project
################################################################################
