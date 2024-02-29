Java OOP with composite and strategy patterns for deep searching and filters. 

Participants can be organized into groups and bands, a group or band has a list of members that make it up (they can be members or even sub-bands). A band or group has a name, and an age (which is calculated as the average of the ages of each of its members). The preferred genders are calculated as the intersection of the preferred genders of all its members. For example, if a group has two members A and B, member A has preferences {g1,g2,g3,g4} and member B has preferences {g1,g4,g7,g11}, the group will have gender preferences { g1, g4}. In the case of the languages that a band or group can play, the union of the languages of all its members is considered (they cannot exist repeated), the same occurs for the instruments that a band can play.

Each coach/jury has a list of participants assigned as their own team, this list may include Bands, Groups or Solo Members.
For better organization, each coach/juror wants to be able to obtain:
● A list of all the instruments that the participants on your team can play (there should be no repeats)
● A list of all the languages that your team participants can sing (no repeated languages)
● A list of preferred genres of the participants on your team (not repeated and ordered alphabetically)
● The average age of your team

For the battles, it is desired that each of the coaches/jurors can search among their participants for members, bands or groups that:
● Sing in a certain language, for example “English”
● They prefer a certain genre, for example “rock”.
● Sing in a certain language and play a specific instrument. For example, “German”
and “Guitar”
● All participants over a certain age.
● They can interpret a certain musical theme
● The above are some examples of the lists that the production constantly asks of the juries. New search requirements can be added as well as logical combinations of existing ones.

##Battles
A battle involves two participants (be it band, group or soloist) facing each other (it can even be a soloist against a band). If a participant wins a battle against another participant, 1 is returned, in the case of a tie a 0 and in the case of a loss a -1. Since production is somewhat capricious, there are different forms of power.
determine if a participant wins a battle, which production can change at any time depending on the rating the program is having:
● If the number of instruments you play is greater than that of your opponent.
● If the number of preferred genres is less than that of your opponent.
● If the number of instruments he plays is greater than that of his rival, and if they are equal, the tie is broken because he is older
● If the age is older than that of your opponent and in case of a tie it is decided by who knows more languages than your opponent.
The above are some examples of battles between two participants, it may even be that there are more than two linked ways, meaning that if the first two give a tie, a third way is decided. A mechanism must be provided that allows two participants to face each other in the contest and the winner is determined according to the form of the battle that is being used at that time.
moment.
