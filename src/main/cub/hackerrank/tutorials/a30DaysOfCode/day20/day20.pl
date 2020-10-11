#!/usr/bin/env perl

$n = <STDIN>;
chomp $n;
$a_temp = <STDIN>;
@a = split / /, $a_temp;
chomp @a;

# Write Your Code Here
my $totalNumberOfSwaps = 0;
for (my $i = 0; $i < $n; $i++) {
  my $numberOfSwaps = 0;
  for (my $j = 0; $j < $n - 1; $j++) {
    if ($a[$j] > $a[$j + 1]) {
      ($a[$j], $a[$j + 1]) = ($a[$j + 1], $a[$j]);
      $numberOfSwaps++;
    }
  }
  $totalNumberOfSwaps += $numberOfSwaps;

  last if $numberOfSwaps == 0;
}

print("Array is sorted in $totalNumberOfSwaps swaps.\n");
print("First Element: " . $a[0] . "\n");
print("Last Element: " . $a[$n - 1] . "\n");
