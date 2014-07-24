# - Try to find Maven
# - Copied from one of cmake templates
# -------------------------
# Once done this will define
#
#  Maven_FOUND - system has Maven
#  Maven_EXECUTABLE - the Maven executable

#=============================================================================
# Copyright 2014 Kurento
#
#=============================================================================

set (NPM_ROOT /usr/bin CACHE STRING "maven directory")

find_program(Maven_EXECUTABLE NAMES maven
        HINTS ENV${NPM_ROOT}/maven ${NPM_ROOT}/maven)

# handle the QUIETLY and REQUIRED arguments and set Maven_FOUND to TRUE if
# all listed variables are TRUE
include(FindPackageHandleStandardArgs)
find_package_handle_standard_args (Maven
  FOUND_VAR Maven_FOUND
  REQUIRED_VARS Maven_EXECUTABLE
)

mark_as_advanced(Maven_FOUND Maven_EXECUTABLE)
