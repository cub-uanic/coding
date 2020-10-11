#!/usr/bin/env perl

# Enter your code here. Read input from STDIN. Print output to STDOUT

my $line;

$line = <STDIN>;
chomp $line;
my ($da, $ma, $ya) = split(' ', $line);

$line = <STDIN>;
chomp $line;
my ($de, $me, $ye) = split(' ', $line);

if ($ya < $ye || ($ya == $ye && $ma < $me) || ($ya == $ye && $ma == $me && $da <= $de)) {
  print(0);
}
elsif ($ya > $ye) {
  print("10000");
}
elsif ($ma > $me) {
  print(500 * ($ma - $me));
}
elsif ($da > $de) {
  print(15 * ($da - $de));
}

print("\n");
