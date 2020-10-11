#!/usr/bin/env perl

use strict;
use warnings;

my $N = <>;
$N =~ s/\s+$//;

my $db = [];

for (my $N_itr = 0; $N_itr < $N; $N_itr++) {
  my $firstNameEmailID = <>;
  $firstNameEmailID =~ s/\s+$//;
  my @firstNameEmailID = split /\s+/, $firstNameEmailID;

  my $firstName = $firstNameEmailID[0];
  chomp($firstName);

  my $emailID = $firstNameEmailID[1];
  chomp($emailID);

  push(@$db, [ $firstName, $emailID ]);
}

print join("\n" => sort {$a cmp $b}
  map {$_->[0]}
    grep {$_->[1] =~ m/^.*\@gmail.com$/}
      @$db
)
