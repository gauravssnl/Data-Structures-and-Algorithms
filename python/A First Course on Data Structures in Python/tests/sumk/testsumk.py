from ds.analysis.sumk import sumk, optimal_sumk
from ds.analysis.timetrials import timetrails


timetrails(optimal_sumk, n=1000, trials=100000)
timetrails(sumk, n=10000, trials=100)