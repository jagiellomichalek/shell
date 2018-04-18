import os
import tensorflow as tf
import numpy as np
import sys
import time
from six.moves import xrange
import gen.generator as gens
import disc.hier_disc as h_disc
import random
import utils.conf as conf
import utils.data_utils as data_utils

gen_config = conf.gen_config
disc_config = conf.disc_config
evl_config = conf.disc_config


def disc_pre_train():
    h_disc.hier_train(disc_config, evl_config)

def gen_pre_train():
    
