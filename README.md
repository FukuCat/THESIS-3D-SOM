# THESIS-3D-SOM

ribbon-like structure
compare distance

1. point to point euclidian distance
   tx(distance(A-B))
   weakness = varying length
   solutions = split, extend, shrink, moving window
2. longest match
   weakness = processing time, windowing (size)
3. block comparison
   how to know what size per block
4. DSP = comparing two similar soundwaves
   testing multiple algorithms

determine which algorithm is more adequate

Steps:
1. Obtain more data in the form of symphonies
2. Pre-processing
2.1 Split the symphonies into 1 sec segments, overlap 0.5 segment (cut last portion if kulang) wavsplitter
2.2 jAudio-feature extraction ->output: xml file
2.3 run regex (regular expression) to extract XML values
2.4 labelling phase (era, composer, composition, movement)
2.5 feature selection (20features out of 600 if we want only 20)
2.5.1 select what to classify (per composer or per composition?)
2.5.2 run different ML algo
2.5.3 model (decision tree diagram)
2.5.4 determine the accuracy false positive, true positive to find best algo

...dataset and som...
1. Plot the music in the SOM
2. xy

actual music vs output % -> verification
output vid vs output vid
last frame vs last frame
