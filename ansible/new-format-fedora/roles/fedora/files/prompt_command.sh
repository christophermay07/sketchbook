################################################################################

#######################
# Prompt Command: Git #
#######################

prompt_command () {
    ## Display error code -- this MUST be at the top of this function

    EXIT_CODE="$?"

    if [ ${EXIT_CODE} -eq 0 ]; then # set an error string for the prompt, if applicable
        ERRPROMPT=""
    else
        ERRPROMPT='->($EXIT_CODE)'
    fi

    ## Set color variables
    local BLACK="\[\033[0;30m\]"
    local GRAY="\[\033[1;30m\]"

    local RED="\[\033[0;31m\]"
    local LRED="\[\033[1;31m\]"

    local GREEN="\[\033[0;32m\]"
    local LGREEN="\[\033[1;32m\]"

    local BROWN="\[\033[0;33m\]"
    local YELLOW="\[\033[1;33m\]"

    local BLUE="\[\033[0;34m\]"
    local LBLUE="\[\033[1;34m\]"

    local PURPLE="\[\033[0;35m\]"
    local LPURPLE="\[\033[1;35m\]"

    local CYAN="\[\033[0;36m\]"
    local LCYAN="\[\033[0;36m\]"

    local LGRAY="\[\033[0;37m\]"
    local WHITE="\[\033[1;37m\]"

    ## Default Terminal text color
    local DEFAULT="\[\033[0;39m\]"

    ## Set the error prompt color
    ERRPROMPT="${RED}${ERRPROMPT}"

    # Non-empty value: Display unstaged (*) and staged(+) changes
    export GIT_PS1_SHOWDIRTYSTATE="x"

    # Non-empty value: Display stashed ($) changes
    export GIT_PS1_SHOWSTASHSTATE=""

    # Non-empty value: Display untracked (%) files
    export GIT_PS1_SHOWUNTRACKEDFILES="x"

    # Display ahead (>), behind (<), or diverged (<>) relative to upstream
    export GIT_PS1_SHOWUPSTREAM="auto"

    ## Git -- show current branch
    if [ "\$(type -t __git_ps1)" ]; then
        BRANCH="\$(__git_ps1 '(%s)')"
    else
        BRANCH=""
    fi

    local PS1_USER="${LRED}\u"
    local PS1_HOSTNAME="${LBLUE}@\h"
    local PS1_TIME="${LGRAY}\t"
    local PS1_DIR="${LBLUE}\W"

    # Depending on how terminal displays, green may look better than light purple
    #local PS1_BRANCH="${GREEN}${BRANCH}"
    local PS1_BRANCH="${LPURPLE}${BRANCH}"

    ## Clear PS1
    PS1=""

    ## Display user, hostname, and time
    PS1="${PS1}${LBLUE}[ ${PS1_USER}${PS1_HOSTNAME} ${PS1_TIME} ${PS1_DIR}${PS1_BRANCH} ${LBLUE}]"

    ## Error indicator
    PS1="${PS1}${ERRPROMPT}"

    ## Bash prompt delimiter (with color reset)
    PS1="${PS1} ${DEFAULT}\$ "

    export PS1
}
