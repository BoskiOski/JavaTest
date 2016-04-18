Given a messenger
When set argument to inf.edu.pl
Then connection should return 0

When set argument to edu.eu
Then connection should return 1

When set arguments to ug.inf.edu.pl and wiadomosc
Then send message should return 0

When set arguments to ug.inf.eu and wiadomosc
Then send message should return 1

When set arguments to ug.inf.edu.pl and ab
Then send message should return 2

When set arguments to lol and some message
Then send message should return 2

When set arguments to zle and nm
Then send message should return 2
