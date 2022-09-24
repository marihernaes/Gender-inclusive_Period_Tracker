# Gender-inclusive Period Tracker
(In progress). A period tracker for mentruating persons which does not share any personal data.
The code is based on the repository "Telle" as well as the "Sunflower" app and Android's best practises: https://github.com/android/sunflower/.

## Screenshots
<img src="today.jpeg" alt="drawing" width="200"/> <img src="history.jpeg" alt="drawing" width="200"/>

Left: A progress bar, estimating days to next period. Right: A list of the periods in the database

## Libraries
- [Room][0] - For accessing the SQLite database
- [ViewModel][3] - Manage data in a lifecycle-concious way
- [LiveData][2] - For observing data
- [Fragment][5] - For flexible UI designs
- [Layout][4] - For defining the structure of the UI
- [Data Binding][1] - For binding layout to views

[0]: https://developer.android.com/topic/libraries/architecture/room 
[1]: https://developer.android.com/topic/libraries/data-binding/
[2]: https://developer.android.com/topic/libraries/architecture/livedata
[3]: https://developer.android.com/topic/libraries/architecture/viewmodel
[4]: https://developer.android.com/guide/topics/ui/declaring-layout
[5]: https://developer.android.com/guide/components/fragments

## Todos
- Continue migration to the new project
- Include new UX design
- Add symptoms on a single-day basis.
- Display more symptoms in list_item_episode.xml.
- Add a "backup" option.
- Implement further analysis of the data
