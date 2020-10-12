#!/usr/bin/env perl

use strict;
use warnings;

my $t = <>;
$t =~ s/\s+$//;

for (my $t_itr = 0; $t_itr < $t; $t_itr++) {
  my $nk = <>;
  $nk =~ s/\s+$//;
  my @nk = split /\s+/, $nk;

  my $n = $nk[0];
  $n =~ s/\s+$//;

  my $k = $nk[1];
  $k =~ s/\s+$//;

  my $a = $k - 1;
  my $b = 0;
  for (; $a > 0; $a--) {
    my $lowestZero = 0;
    my $tmp = $a;
    while ($tmp > 0 && ($tmp & 1) == 1) {
      $tmp >>= 1;
      $lowestZero++;
    }
    $b = $a + (1 << $lowestZero);
    if ($b <= $n) {
      last;
    }
  }
  print($a & $b, "\n");
}
